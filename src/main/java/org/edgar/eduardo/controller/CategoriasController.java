package org.edgar.eduardo.controller;

import java.util.List;
import org.edgar.eduardo.model.Categoria;
import org.edgar.eduardo.model.Vacante;
import org.edgar.eduardo.service.IntCategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//Anotación @RequestMapping a nivel de clase
@RequestMapping(value="/categorias")

public class CategoriasController {
	
    @Autowired
    private IntCategoriasService categoriasService;
    
    @RequestMapping(value="/modificar", method = RequestMethod.GET)
    public String modificar(@RequestParam("id")int idCategoria, Model model) {
    	Categoria categoria = categoriasService.buscarPorId(idCategoria);
    	model.addAttribute("categoria", categoria);
    	return "categorias/formCategoria";
    	
    }
    
    @RequestMapping(value="/eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam("id")int idCategoria,
    		               RedirectAttributes attributes) {
    	categoriasService.eliminar(idCategoria);
    	attributes.addFlashAttribute("msg2", "Categoria eliminada");
    	return "redirect:/categorias/index";
    }
    @RequestMapping(value="/indexPaginate", method=RequestMethod.GET)
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Categoria>lista = categoriasService.buscarTodas(page);
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
		}

	//@GetMapping("/index")
	//anotación a nivel de metodo	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Categoria> lista = categoriasService.obtenerTodas();
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}
	
	//@GetMapping("/crear")
	@RequestMapping(value="/crear", method=RequestMethod.GET)
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	 @RequestMapping(value="/guardar", method = RequestMethod.POST)
	public String guardar (Categoria categoria, 
			BindingResult result,
			RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
				}
			return "vacantes/formCategoria";
			}
		
		/*System.out.println("Categoria: " + categoria); 
		//guardar el objeto tipo vacante*/
		//categoria.setId(categoriasService.obtenerTodas().size()+1);
		//System.out.println("Numero de registros : " + categoriasService.obtenerTodas().size());
		attributes.addFlashAttribute("msg", "El registro se realizo con exito");
		categoriasService.guardar(categoria);
		return "redirect:/categorias/index";		
	}

}
