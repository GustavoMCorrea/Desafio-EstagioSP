
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class FaturamentoDistribuidora {
    public static void main(String[] args) throws Exception {
        // Leitura dos dados de faturamento diário a partir de um arquivo JSON
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(new FileReader("dados.json"));
        List<Double> faturamentoDiario = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            JSONObject jsonObject = (JSONObject) json.get(i);
            double valor = (Double) jsonObject.get("valor");
            LocalDate data = LocalDate.of(2023, Month.MARCH, (int) (long) jsonObject.get("dia"));
            if (data.getDayOfWeek().getValue() < 6) { // Ignora finais de semana
                faturamentoDiario.add(valor);
            }
        }

        // Cálculo do menor valor de faturamento ocorrido em um dia do mês
        double menorFaturamento = Double.MAX_VALUE;
        for (double valor : faturamentoDiario) {
            if (valor < menorFaturamento) {
                menorFaturamento = valor;
            }
        }

        // Cálculo do maior valor de faturamento ocorrido em um dia do mês
        double maiorFaturamento = Double.MIN_VALUE;
        for (double valor : faturamentoDiario) {
            if (valor > maiorFaturamento) {
                maiorFaturamento = valor;
            }
        }

        // Cálculo da média mensal
        double somaFaturamento = 0;
        for (double valor : faturamentoDiario) {
            somaFaturamento += valor;
        }
        double mediaMensal = somaFaturamento / faturamentoDiario.size();

        // Cálculo do número de dias no mês em que o valor de faturamento diário foi superior à média mensal
        int diasAcimaMedia = 0;
        for (double valor : faturamentoDiario) {
            if (valor > mediaMensal) {
                diasAcimaMedia++;
            }
        }

        // Impressão dos resultados
        System.out.println("Menor valor de faturamento: R$" + String.format("%.2f", menorFaturamento));
        System.out.println("Maior valor de faturamento: R$" + String.format("%.2f", maiorFaturamento));
        System.out.println("Número de dias com faturamento acima da média mensal: " + diasAcimaMedia);
    }
}