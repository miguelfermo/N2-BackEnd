package Projeto.Intermediario.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LatLonService {

    private final RestTemplate restTemplate;

    public LatLonService() {
        this.restTemplate = new RestTemplate();
    }

    public HashMap<String, String> getWeather(String cityName) {
        // Buscar latitude e longitude
        String url = "https://www.meteoblue.com/en/server/search/query3?query=" + cityName;
        Map response = restTemplate.getForObject(url, Map.class);
        HashMap<String, String> RespostaPersonalizada = new HashMap<>();
        try{
            if (response == null || response.get("results") == null || ((List<?>) response.get("results")).isEmpty()) {
                RespostaPersonalizada.put("erro", "Cidade não encontrada!");
            }
            else{
                Map firstResult = (Map) ((List<?>) response.get("results")).get(0);
                Double lat = (Double) firstResult.get("lat");
                Double lon = (Double) firstResult.get("lon");

                RespostaPersonalizada.put("latitude", lat.toString());
                RespostaPersonalizada.put("longitude", lon.toString());
            }
        }
        catch (Exception e) {
            RespostaPersonalizada.put("erro", "Erro ao obter Latitude e Longitude!");
        }
        return RespostaPersonalizada;
    }
}