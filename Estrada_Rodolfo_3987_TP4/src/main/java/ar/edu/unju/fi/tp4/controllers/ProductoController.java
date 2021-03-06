package ar.edu.unju.fi.tp4.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.models.Producto;
import ar.edu.unju.fi.tp4.services.IProductoService;

@Controller
public class ProductoController {
	private static final Log LOGGER = LogFactory.getLog(ProductoController.class);
	
	@Autowired
	IProductoService productoService;
	@GetMapping("/producto")
	
	public String getProductoFormPage(Model model) {
		LOGGER.info("CONTROLLER: ProductoController");
		LOGGER.info("METHOD: getProductoFormPage()");
		LOGGER.info("RESULT: visualiza la pagina nuevo_producto.html");
		model.addAttribute("producto", productoService.getProducto());
	return "nuevo_producto";
	}
	
	@PostMapping("/producto/guardar")
	public String getProductoResultPage(@ModelAttribute("producto") Producto unProducto) {
		LOGGER.info("CONTROLLER: ProductoController");
		LOGGER.info("METHOD: getProductoResultPage()");
		LOGGER.info("RESULT: muestra en la pagina resultado_producto.html un mensaje que el producto se guardó exitosamente");
		productoService.addProducto(unProducto);
		return "resultado_producto";
	}
	
	@GetMapping("/producto/ultimo")
	public ModelAndView getUltimoProducto() {
		LOGGER.info("CONTROLLER: ProductoController");
		LOGGER.info("METHOD: getUltimoProducto()");
		LOGGER.info("RESULT: muestra la pagina producto.html con el ultimo producto agregado");
		ModelAndView mav = new ModelAndView("ultimo_producto");
		mav.addObject("producto", productoService.getUltimoProducto());
		return mav;
	}
	
	@GetMapping("/producto/listado")
	public ModelAndView getListProductoPage() {
		LOGGER.info("CONTROLLER: ProductoController");
		LOGGER.info("METHOD: getListProductoPage()");
		LOGGER.info("RESULT: visualiza en la pagina productos.html la lista de todos los productos");
		ModelAndView modelAndView = new ModelAndView("productos");
		modelAndView.addObject("productos", productoService.getListProductos());
		return modelAndView;
	}
	
}
