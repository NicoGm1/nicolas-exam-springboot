package fr.nsurget.nicolasexamspringboot.Citydex.controller;


import fr.nsurget.nicolasexamspringboot.Citydex.dto.UserPostDTO;
import fr.nsurget.nicolasexamspringboot.Citydex.mapping.WebUrlRoute;
import fr.nsurget.nicolasexamspringboot.Citydex.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class SecurityController {

    private UserService userService;

    @GetMapping(WebUrlRoute.URL_REGISTER)
    public ModelAndView register(ModelAndView mav) {
        mav.setViewName("security/register");
        mav.addObject("userPostDTO", new UserPostDTO());
        return mav;
    }

    @PostMapping(WebUrlRoute.URL_REGISTER)
    public ModelAndView register(
            @ModelAttribute("userPostDTO") @Valid UserPostDTO userPostDTO,
            BindingResult bindingResult,
            ModelAndView mav
    ) {
        if (bindingResult.hasErrors()) {
            mav.setViewName("security/register");
            return mav;
        }
        userService.create(userPostDTO);
        mav.setViewName("redirect:" + WebUrlRoute.URL_HOME);
        return mav;
    }

    @GetMapping(value = WebUrlRoute.URL_LOGIN)
    public ModelAndView login(ModelAndView mav, String error) {
        if (error != null) {
            mav.addObject("error", "Your username or password is invalid.");
        }
        mav.setViewName("security/login");
        return mav;
    }

}
