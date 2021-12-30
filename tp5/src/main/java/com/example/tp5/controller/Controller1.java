package com.example.tp5.controller;

import com.example.tp5.model.AddressRepository;
import com.example.tp5.request.AddressResultGet;
import com.example.tp5.request.MeteoResultGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class Controller1 {

    @PostMapping("/meteo")
    public String showMeteoAddresses ( @RequestParam(value="address",
            required =false) String addressPost, Model model) {
        model.addAttribute ("oneAddress", addressPost);
        return "meteo";
    }

    @GetMapping("/meteo")
    public String showFormulaire ( Model model) {
        //model.addAttribute ("oneAddress", addressPost);
        return "formulaire";
    }

    private double[] showAddressResult(RestTemplate restTemplate, Model model, String addressPost) {
        String uri = "https://api-adresse.data.gouv.fr/search/?limit=1&q=" + addressPost.replace(" ", "+");
        System.out.println(uri);
        AddressResultGet result = restTemplate.getForObject(uri, AddressResultGet.class);

        String name = result.getFeatures()[0].getProperties().getName();
        String city = result.getFeatures()[0].getProperties().getCity() + ", " +result.getFeatures()[0].getProperties().getContext();

        double lon = result.getFeatures()[0].getGeometry().getCoordinates()[0];
        double lat = result.getFeatures()[0].getGeometry().getCoordinates()[1];

        System.out.println(name);
        System.out.println(city);
        System.out.println(lon);
        System.out.println(lat);

        // Affichage des informations dans le fichier html
        model.addAttribute("name", name);
        model.addAttribute("city", city);

        model.addAttribute("lon", lon);
        model.addAttribute("lat", lat);

        return new double[]{lon, lat};
    }

    private void showMeteoResult(RestTemplate restTemplate, Model model, double lat, double lon) {
        //requête à envoyer
        String uri = "https://api.meteo-concept.com/api/forecast/daily?" +
                "token=dfc7933b44562fa04f04b0fa8a47485dffaa91309b6453e5d2171a4aa633a5ed&" +
                "latlng="+ lat +","+ lon;

        //on récupère ce que l'on a demandé via la requête
        MeteoResultGet result = restTemplate.getForObject(uri, MeteoResultGet.class);

        //on sépare les différentes informations que l'on a récupéré (température, temps, probabilité de pluie etc.)
        int probrain = result.getForecast()[0].getProbrain();
        int tmin = result.getForecast()[0].getTmin();
        int tmax = result.getForecast()[0].getTmax();
        int weather = result.getForecast()[0].getWeather();

        //on affiche ces informations sur la page de la météo
        model.addAttribute("probRain", probrain);
        model.addAttribute("tmin", tmin);
        model.addAttribute("tmax", tmax);
        model.addAttribute("weather", weather);
    }

}
