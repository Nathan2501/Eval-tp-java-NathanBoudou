package com.example.tp.controllersJSP;

import com.example.tp.models.Communes;
import com.example.tp.services.CommunesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityNotFoundException;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/communes")
@Controller
public class CommunesControllerJSP {

    @Autowired
    private CommunesService communesService;

    @RequestMapping(value = "/countCodesPostaux", method = RequestMethod.GET)
    public String countCodesPostaux(Map<String, Object> model) {
        model.put("codePostal", communesService.countCodesPostaux());
        return "countCodePostal";
    }

    @RequestMapping(value = "/idCommune", method = RequestMethod.GET)
    public String getById(Map<String, Object> model) {
        model.put("model", communesService.getCommuneById(1L));
        return "communeID";
    }


}
