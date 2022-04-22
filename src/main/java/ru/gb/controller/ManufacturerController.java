package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.entity.Manufacturer;
import ru.gb.service.ManufacturerService;

@Controller
@RequestMapping("/manufacturer")
@RequiredArgsConstructor
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @RequestMapping(value = "/addManufacturer", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "add-manufacturer";
    }

    @RequestMapping(value = "/addManufacturer", method = RequestMethod.POST)
    public String processForm(Manufacturer manufacturer) {
        if (manufacturer.getId() == null) {
            manufacturerService.save(manufacturer);
        } else {
            manufacturerService.update(manufacturer);
        }
        return "redirect:/manufacturer/allManufacturers";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getManufacturerById(Model model, @PathVariable Long id) {
        Manufacturer manufacturer = null;
        if (id > 0) {
            try {
                manufacturer = manufacturerService.findById(id);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturer";
    }

    @RequestMapping(value = "/allManufacturers", method = RequestMethod.GET)
    public String getAllManufacturers(Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "manufacturer-list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteManufacturerById(@PathVariable Long id) {
        if (id > 0) {
            try {
                manufacturerService.deleteById(id);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/manufacturer/allManufacturers";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String updateManufacturer(Model model, Manufacturer manufacturer) {
        try {
            model.addAttribute("manufacturer", manufacturerService.update(manufacturer));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "add-manufacturer";
    }
}
