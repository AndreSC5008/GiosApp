package net.codejava.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.codejava.services.ClienteService;
import net.codejava.entity.CalculadoraPrecio;
import net.codejava.entity.RegistroCliente;
import net.codejava.services.CotizacionService;

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
    private CotizacionService Pservice;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        
        return "menu";
       
    }
    
    @RequestMapping("/clients")
    public String viewClients(Model model) {

        List<RegistroCliente> listRegistroClientes = service.listAll();
        model.addAttribute("listClientes", listRegistroClientes);
        return "index";
       
    }
    
    
    

    @RequestMapping("/calculadora")
    public String viewCalculadora(Model model){
        List<CalculadoraPrecio> listCotizaciones = Pservice.listAll();
        model.addAttribute("listCotizaciones", listCotizaciones);
        model.addAttribute("precio",new CalculadoraPrecio());
        return "calculadora";
    }
    
    
    @RequestMapping("/cotizar")
    public String costoPastel( Model model, @RequestParam("sabor") String sabor,
            @RequestParam( "tamano") String tamano,
            @RequestParam(value = "decoracion", defaultValue = "sencillo") String decoracion){
        CalculadoraPrecio precio1= new CalculadoraPrecio(sabor, tamano, decoracion);
        String cotizacion = precio1.cotizarPrecio();
        
        model.addAttribute("resultado",cotizacion);
        return "calculadora";
    }

   
    @RequestMapping("/new")
    public String viewRegistrarCliente(Model model) {
        RegistroCliente cliente = new RegistroCliente();
        model.addAttribute("cliente", cliente);
        
        return "new_Registro";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRegistroCliente(@ModelAttribute("cliente") RegistroCliente cliente) {
        
        service.save(cliente);
       
        return "redirect:/clients";
    }
    
    @RequestMapping(value = "/saveCotizacion", method = RequestMethod.POST)
    public String saveRegistroCotizacion(@ModelAttribute("precio") CalculadoraPrecio precio) {
        
        Pservice.save(precio);
       
        return "redirect:/calculadora";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView viewEditRegistroCliente(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_Registro");
        RegistroCliente cliente = service.get(id);
        mav.addObject("cliente", cliente);

        return mav;
    }
    
        
        
    @RequestMapping("/delete/{id}")
    public String deletelistRegistroCliente(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/clients";
    }
}
