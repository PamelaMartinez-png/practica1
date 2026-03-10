package com.upiiz.practica.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.List;
@Controller
public class PracticaController {
//Pamela Guadalupe Martinez Arteaga 2025670142
//Danna Elizama Arredondo Cordero 2025670102
    private final List<Etiquetas> etiquetas=new ArrayList<>();

    public PracticaController(){
        //etiquetas de documento
        etiquetas.add(new Etiquetas("html","Raíz del documento","<html>...</html>","lang, dir","<div>Documento en <b>español</b> (lang='es').</div>!--\"<html>...</html> esta es la sintaxis pero es para dar una demostracion de como se veria-->"));
        etiquetas.add(new Etiquetas("head","Contenedor de metadatos","<head>...</head>","","<p><strong>Título:</strong> Mi página</p><!--\"<head>...</head> esta es la sintaxis pero es para dar una demostracion de como se veria-->"));
        etiquetas.add(new Etiquetas("body","Contenido visible","<body>...</body>","onload","<body><h1>Hola</h1></body>"));
//etiquetas de texto
        etiquetas.add(new Etiquetas("p","Parrafo","<p>Texto</p>","lang","<p>Este es un párrafo de texto plano. Cada vez que abras esta etiqueta, el navegador creará un espacio automático arriba y abajo.</p>"));
        etiquetas.add(new Etiquetas("h1-h6","Contenido visible","<h1>Título</h1>","lang","<h4>Título de nivel 4</h4><h1>Título de nivel 1</h1>"));
        etiquetas.add(new Etiquetas("span","Contenido visible","<span>Texto</span>","lang","<p>Puedo <span style=\"color: blue;\">colorear solo una parte</span> del párrafo.</p>"));
        etiquetas.add(new Etiquetas("strong","Texto con importancia fuerte (negrita).","<strong>Texto</strong>","lang","<strong>leer esto con mucha atención</strong>"));
        etiquetas.add(new Etiquetas("em","Texto con énfasis (cursiva).","<em>Texto</em>","lang","<p>Este texto tiene un <em>énfasis diferente</em>.</p>"));
//etiquetas de imagen
        etiquetas.add(new Etiquetas("a","Hipervínculo","<a href=\"url\">Enlace</a>","href, target","<a href=\"https://web.com\" target=\"_blank\">Link</a>"));
        etiquetas.add(new Etiquetas("img","Imagen","<img src=\"ruta\" alt=\"texto\">","src, alt, width","<img src=\"/media/foto.jpg\" alt=\"Logo\">"));
//listas
        etiquetas.add(new Etiquetas("ul","Lista desordenada","<ul><li>Item</li></ul>","type (disc, circle, square)","<ul><li>Elemento</li></ul>"));
        etiquetas.add(new Etiquetas("ol","Lista ordenada","<ol><li>Item</li></ol>","type (1, A, a, I, i), start, reversed","<ol start=\"1\"><li>Primero</li></ol>"));
        etiquetas.add(new Etiquetas("li","Elemento de lista","<li>Item</li>","value (solo en <ol>)","<li>Item 1</li>"));
//tablas
        etiquetas.add(new Etiquetas("table","Contenedor de tabla","<table>...</table>","border, cellpadding, cellspacing","<table>\n" +
                "  <tr>\n" +
                "    <th>Producto</th> <th>Precio</th>   </tr>\n" +
                "  <tr>\n" +
                "    <td>Pan</td>      <td>$5</td>       </tr>\n" +
                "</table>"));
        etiquetas.add(new Etiquetas("tr","Fila de tabla","<tr>...</tr>","","<tr><td>Fila</td></tr>"));
        etiquetas.add(new Etiquetas("th","Celda de encabezado","<th>Título</th>","colspan, rowspan, scope","<th>Encabezado</th>"));
        etiquetas.add(new Etiquetas("td","Celda de datos","<td>Dato</td>","colspan, rowspan","<td>Dato</td>"));

        etiquetas.add(new Etiquetas("form","Contenedor de formulario","<form action=\"ruta_servidor\" method=\"POST\"> ... </form>","action, method","<form>\n" +
                "  <label for=\"nombre\">Nombre:</label>\n" +
                "  <input type=\"text\" id=\"nombre\">\n" +
                "  \n" +
                "  <select>\n" +
                "    <option>Opción A</option>\n" +
                "    <option>Opción B</option>\n" +
                "  </select>\n" +
                "\n" +
                "  <button type=\"submit\">Enviar</button>\n" +
                "</form>"));
        etiquetas.add(new Etiquetas("input","Entrada de datos","<input type=\"text\" id=\"nombre\" name=\"usuario\" placeholder=\"Tu nombre\">","type, name, value","<input type=\"text\" name=\"user\" placeholder=\"Nombre\">"));
        etiquetas.add(new Etiquetas("label","Etiqueta para un input","<label for=\"nombre\">Nombre:</label>","for, id","<label for=\"nombre\">Nombre:</label>"));
        etiquetas.add(new Etiquetas("button","Botón interactivo","<button type=\"submit\">Enviar datos</button>","type, disabled","<button type=\"submit\">Enviar</button>"));
        etiquetas.add(new Etiquetas("select","Menú desplegable","<select name=\"opciones\"> <option value=\"1\">Opción 1</option> </select>","name, size, multiple, required","<select name=\"opcion\"><option>1</option></select>"));

        etiquetas.add(new Etiquetas("audio","Reproductor de audio","<audio>...</audio>","src, controls, autoplay","<audio controls src=\"/media/video.ogg\"></audio>"));
        etiquetas.add(new Etiquetas("video","Reproductor de video","<video>...</video>","src, controls, width, height","<video controls src=\"/media/video.mp4\" width=\"300\"></video>"));

    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("etiquetas",etiquetas);
        return "index";
    }
    @GetMapping("/etiqueta/{nombre}")
    public String detalle(@PathVariable String nombre, Model model) {
        // buscar la etiqueta por nombre

        Etiquetas etiquetaEncontrada = etiquetas.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);


        model.addAttribute("etiqueta", etiquetaEncontrada);
        return "informacion";
    }

}
