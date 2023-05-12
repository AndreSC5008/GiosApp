package net.codejava.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.codejava.services.ClienteService;
import net.codejava.entity.CalculadoraPrecio;
import net.codejava.entity.Usuario;
import net.codejava.entity.RegistroCliente;
import net.codejava.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private ClienteService service;
    @Autowired
    private UserService Uservice;

    @RequestMapping("/")
    public String viewHomePage(Model model) {

        List<RegistroCliente> listRegistroClientes = service.listAll();
        model.addAttribute("listClientes", listRegistroClientes);
        return "index";
       
    }

    @RequestMapping("/calculadora")
    public String viewCalculadora(){
 
        return "calculadora";
    }
    
    
    @RequestMapping("/cotizar")
    public String costoPastel( Model model, @RequestParam("sabor") String sabor,
            @RequestParam( "tamano") String tamano,
            @RequestParam(value = "decoracion", defaultValue = "sencillo") String decoracion){
        CalculadoraPrecio precio= new CalculadoraPrecio(sabor, tamano, decoracion);
        double cotizacion = precio.cotizarPrecio();
        model.addAttribute("resultado",cotizacion);
        return "calculadora";
    }

   
    @RequestMapping("/new")
    public String viewRegistrarCliente(Model model) {
        RegistroCliente cliente = new RegistroCliente();
        model.addAttribute("cliente", cliente);
        
        return "new_RegistroImc";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRegistroCliente(@ModelAttribute("cliente") RegistroCliente cliente) {
        
        service.save(cliente);
       
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView viewEditRegistroCliente(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_RegistroImc");
        RegistroCliente cliente = service.get(id);
        mav.addObject("cliente", cliente);

        return mav;
    }
    
        
        
    @RequestMapping("/delete/{id}")
    public String deletelistRegistroCliente(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
