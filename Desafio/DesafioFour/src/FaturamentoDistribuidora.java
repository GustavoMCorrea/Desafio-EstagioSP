import java.util.HashMap;
import java.util.Map;

public class FaturamentoDistribuidora {
    public static void main(String[] args) {

        Map<String, Double> faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);


        double totalFaturamento = 0;
        for (double valor : faturamentoPorEstado.values()) {
            totalFaturamento += valor;
        }


        Map<String, Double> porcentagemPorEstado = new HashMap<>();
        for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
            double porcentagem = (entry.getValue() / totalFaturamento) * 100;
            porcentagemPorEstado.put(entry.getKey(), porcentagem);
        }

        // Impressão dos resultados
        System.out.println("Total de faturamento: R$" + totalFaturamento);
        for (Map.Entry<String, Double> entry : porcentagemPorEstado.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.format("%.2f", entry.getValue()) + "%");
        }

        
        String estadoMaiorFaturamento = "";
        double maiorFaturamento = 0;
        for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
            if (entry.getValue() > maiorFaturamento) {
                estadoMaiorFaturamento = entry.getKey();
                maiorFaturamento = entry.getValue();
            }
        }
        System.out.println("Estado com o maior faturamento: " + estadoMaiorFaturamento);
    }
}
