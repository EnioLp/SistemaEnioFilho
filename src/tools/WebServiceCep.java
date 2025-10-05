package tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WebServiceCep {

    // Classe interna para representar os dados do endereço
    public static class Cep {
        private String logradouro, bairro, cidade, uf;

        public String getLogradouro() { return logradouro; }
        public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
        public String getBairro() { return bairro; }
        public void setBairro(String bairro) { this.bairro = bairro; }
        public String getCidade() { return cidade; }
        public void setCidade(String cidade) { this.cidade = cidade; }
        public String getUf() { return uf; }
        public void setUf(String uf) { this.uf = uf; }
    }

    /**
     * Busca um CEP no serviço ViaCEP.
     * @param cep String com o CEP (com ou sem formatação)
     * @return um objeto Cep com os dados do endereço, ou null se não encontrar.
     */
    public static Cep buscaCep(String cep) {
        try {
            // Cria a URL para a API ViaCEP
            URL url = new URL("https://viacep.com.br/ws/" + cep.replace("-", "") + "/json/");
            
            // Abre a conexão
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Verifica se a requisição foi bem-sucedida (código 200)
            if (conn.getResponseCode() != 200) {
                System.err.println("Erro HTTP " + conn.getResponseCode() + " ao buscar CEP.");
                return null;
            }

            // Lê a resposta JSON
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            conn.disconnect();
            
            // Converte a resposta para um objeto JSON
            JSONObject jsonObject = new JSONObject(response.toString());

            // ViaCEP retorna {"erro": true} se o CEP não for encontrado
            if (jsonObject.has("erro")) {
                return null;
            }

            // Cria e preenche nosso objeto Cep
            Cep cepObjeto = new Cep();
            cepObjeto.setLogradouro(jsonObject.getString("logradouro"));
            cepObjeto.setBairro(jsonObject.getString("bairro"));
            cepObjeto.setCidade(jsonObject.getString("localidade"));
            cepObjeto.setUf(jsonObject.getString("uf"));
            
            return cepObjeto;
            
        } catch (Exception e) {
            System.err.println("Erro ao buscar CEP: " + e.getMessage());
            return null;
        }
    }
}