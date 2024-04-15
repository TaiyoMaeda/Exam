package jp.ac.C.ohara.teamseisaku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.C.ohara.teamseisaku.model.StudentModel;
import jp.ac.C.ohara.teamseisaku.service.StudentService;



@Controller
public class MainController {
	@Autowired
	private StudentService stService;

	
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "Hello");
    return "top";
  }


	//("")の中はlocalhost:8080の後に続くURLを記述　(localhost:8080/student/に表示させたいので"/student/")
	@GetMapping("/student/")
	//そのページで使うmodelのインスタンス化　(学生表登録フォームなのでStudentModelをインスタンス化)
	  public ModelAndView add(StudentModel studentmodel, ModelAndView model) {
	      model.addObject("studentmodel", studentmodel);
	      // ()の中にアクセスしたいHTMLファイルの.htmlを省いたファイルの名前を記述
	      model.setViewName("studentH");
	      return model;
	}

	//("")の中はlocalhost:8080の後に続くURLを記述　(localhost:8080/sekiseki/に表示させたいので"/seiseki/")
	@GetMapping("/studentII/")
	//そのページで使うmodelのインスタンス化　(学生表登録フォームなのでGakuseiHyouをインスタンス化)
	  public String add(Model model) {
	      model.addAttribute("StudentList", stService.getStudentList());
	      return "studentI";
}


//Form送信
	@PostMapping("/student/")
		public String studentmodel(@Validated @ModelAttribute @NonNull StudentModel studentmodel, RedirectAttributes result, ModelAndView model,
          RedirectAttributes redirectAttributes) {
			try {
				this.stService.save(studentmodel);
				redirectAttributes.addFlashAttribute("exception", "");

			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("exception", e.getMessage());
		    	System.out.println(e);
			}
			return "redirect:/student/";

    	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id") Long id, StudentModel StudentModel, ModelAndView model) {
		this.stService.delete(id);
		model.setViewName("delete");
		return model;
	}
	//DB変更
	@GetMapping("/studentII/edit/{id}")
	public void editStudent(@PathVariable Long id, Model model) {
	    StudentModel student = stService.getStudentById(id);
	    model.addAttribute("student", student);
	}

		
	@PostMapping("/studentII/update/{id}")
	public String change(@PathVariable Long id, @Validated @ModelAttribute @NonNull StudentModel student, RedirectAttributes redirectAttributes) {
	    student.setId(id);
	    try {
	        stService.save(student);
	        redirectAttributes.addFlashAttribute("exception", "");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("exception", e.getMessage());
	    }
	    return "redirect:/studentII/";
	}
	


}