package com.linking.demoproject.controllers;

import com.linking.demoproject.models.Equipo;
import com.linking.demoproject.models.Jugador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ParametrosControllers {

    @GetMapping("/parametros")
    public String parametros(@RequestParam(defaultValue = "") String val,@RequestParam(defaultValue = "Sin nombre") String nombre, Model model){
        model.addAttribute("titulo","Parametros");
        model.addAttribute("parametro",val);
        model.addAttribute("nombre",nombre);
        return "parametros";
    }

    @GetMapping("/equipos/{nombre}/{numero}")
    public String parametrosPorPath(@PathVariable String nombre, @PathVariable("numero") Integer numero, Model model){
        Optional<Equipo> equipoOptional=getEquipos().stream().filter(equipo -> nombre.toLowerCase().equals(equipo.getNombre().toLowerCase())).findFirst();
        if (equipoOptional.isPresent()){
            Optional<Jugador> jugadorOptional=equipoOptional.get().getPlantilla().stream().filter(jugador -> numero==jugador.getNumero()).findFirst();
            if (jugadorOptional.isPresent()){
                model.addAttribute("jugador",jugadorOptional.get());
            }
        }
        return "parametros";
    }

    private List<Equipo> getEquipos(){
        Equipo barcelona=new Equipo();
        barcelona.setNombre("Barcelona");
        barcelona.addJugador(new Jugador("TER STEGEN",1));
        barcelona.addJugador(new Jugador("ARAUJO",4));
        barcelona.addJugador(new Jugador("BUSQUETS",5));
        barcelona.addJugador(new Jugador("LEWANDOSKI",9));
        barcelona.addJugador(new Jugador("DEMBELE",7));

        Equipo realMadrid=new Equipo();
        realMadrid.setNombre("RealMadrid");
        realMadrid.addJugador(new Jugador("COURTOIS",1));
        realMadrid.addJugador(new Jugador("CARVAJAL",2));
        realMadrid.addJugador(new Jugador("MODRIC",10));
        realMadrid.addJugador(new Jugador("BENZEMA",9));
        realMadrid.addJugador(new Jugador("HAZARD",7));
        return List.of(barcelona,realMadrid);
    }
}
