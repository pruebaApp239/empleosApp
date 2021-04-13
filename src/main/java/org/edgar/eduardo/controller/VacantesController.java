package org.edgar.eduardo.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.edgar.eduardo.model.Vacante;
import org.edgar.eduardo.service.IntCategoriasService;
import org.edgar.eduardo.service.IntVacantesService;
import org.edgar.eduardo.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/vacantes")
public class VacantesController {
	
	@Autowired
	private IntCategoriasService serviceCategorias;
	
	@Autowired
	private IntVacantesService serviceVacantes;
	
	@GetMapping("/editar")
	public String editar(@RequestParam("id") int idVacante, Model model) {
		//recuperar una vacante
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		//model.addAttribute("categorias", serviceCategorias.obtenerTodas());
		model.addAttribute("vacante", vacante);
		return "vacantes/formVacante";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Vacante>lista = serviceVacantes.buscarTodas(page);
		model.addAttribute("vacantes", lista);
		return "vacantes/listaVacantes";
		}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List <Vacante> lista = serviceVacantes.obtenerTodas();
		model.addAttribute("vacantes", lista);
		return "vacantes/listaVacantes";
	}
	
	@PostMapping("/guardar")
	public String guardar(Vacante vacante, 
			BindingResult result,
			RedirectAttributes attributes, Model model,
			@RequestParam("archivoImagen") MultipartFile multiPart) {
		
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
				}
			model.addAttribute("categorias", serviceCategorias.obtenerTodas());
			return "vacantes/formVacante";
		}
			if (!multiPart.isEmpty()) {
				//String ruta = "/empleos/img-vacantes/"; 
				// Linux/MAC
				String ruta = "c:/empleos/img-vacantes/"; // Windows
				String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
				if (nombreImagen != null){ // La imagen si se subio
					// Procesamos la variable nombreImagen
					vacante.setImagen(nombreImagen); }
				    
				}
		
		System.out.println("Vacante: " + vacante); 
		//guardar el objeto tipo vacante
		//vacante.setId(serviceVacantes.obtenerTodas().size()+1);
		serviceVacantes.guardar(vacante);
		System.out.println("Numero de registros : " + serviceVacantes.obtenerTodas().size());
		attributes.addFlashAttribute("msg", "El registro se realizo con exito");
		return "redirect:/vacantes/index";
        }

	/*@PostMapping("/guardar")
	private String guardar(@RequestParam("nombre")String nombre, 
			@RequestParam("descripcion") String descripcion,
			@RequestParam("estatus")String estatus,
			@RequestParam("fecha")String fecha,
			@RequestParam("destacado")int destacado,
			@RequestParam("salario")double salario,
			@RequestParam("detalles")String detalles
			) {
		Vacante v = new Vacante ();
		v.setNombre(nombre);
		v.setDescripcion(descripcion);
		v.setEstatus(estatus);
		//v.setFecha(fecha);
		v.setDestacado(destacado);
		v.setSalario(salario);
		v.setDetalles(detalles);
		System.out.println("Vacante : " + v);
		 //guardar en la tabla correspondiente
		return "vacantes/listaVacantes";
	}*/
	
	@GetMapping("/crear")
	public String crear(Vacante vacante, Model model) {
		//model.addAttribute("categorias", serviceCategorias.obtenerTodas());
		
		return "vacantes/formVacante";
	}
	
	@GetMapping("/detalle/{id}")
	public String verDetalle (@PathVariable("id") int idVacante, Model model) {
		System.out.println("IdVacante : " + idVacante);
		model.addAttribute("vacante", serviceVacantes.buscarPorId(idVacante));
		System.out.println(serviceVacantes.buscarPorId(idVacante));
		model.addAttribute("id", idVacante);
		return "vacantes/detalle";
	}
	
	@GetMapping("/eliminar")
	//RequestParam(Binding)
	public String eliminar (@RequestParam("id") int idVacante, 
			                  RedirectAttributes attributes) {		
		//System.out.println("IdVacante = " + idVacante);
		attributes.addFlashAttribute("msg", "Vacante eliminada"); 
		serviceVacantes.eliminar(idVacante);
		return "redirect:/vacantes/index";	
	}
	
	//Mostrar comunes en el metodo del cotrolador
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categorias", serviceCategorias.obtenerTodas());

	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
      binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
        @Override
        public void setAsText(String text) throws IllegalArgumentException{
          setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }

        @Override
        public String getAsText() throws IllegalArgumentException {
          return DateTimeFormatter.ofPattern("dd-MM-yyyy").format((LocalDate) getValue());
        }
      });
    }
}

