import java.text.DecimalFormat;
import java.util.Scanner;

public class Impostos {

	public static void main(String[] args) {

		String nomeCliente;
		int quantidadeComprada;
		double valorUnitario = 4.50;
		double icms;
		double icmsDesconto;
		double ipi;
		double ipiDesconto;
		double pis;
		double pisDesconto;
		double cofins;
		double cofinsDesconto;
		double totalImpostos;
		double totalImpostosDesconto;
		double totalMercadorias;
		double totalMercadoriasDesconto;
		double totalGeral;
		double totalGeralDesconto;

		Scanner teclado = new Scanner(System.in);

		System.out.println("Informe o Nome do Cliente");
		nomeCliente = teclado.next();

		System.out.println("Informe a Quantidade Comprada");
		quantidadeComprada = teclado.nextInt();

		totalMercadorias = valorUnitario * quantidadeComprada;

		icms = (totalMercadorias * 18) / 100;
		ipi = (totalMercadorias * 4) / 100;
		pis = (totalMercadorias * 1.86) / 100;
		cofins = (totalMercadorias * 8.54) / 100;

		totalImpostos = icms + ipi + pis + cofins;

		totalGeral = totalMercadorias + totalImpostos;

		System.out.println("Cliente: " + nomeCliente);
		System.out.println("--------------------------------------------");

		DecimalFormat df = new DecimalFormat("#,##0.00");

		String icmsReais = df.format(icms);
		String ipiReais = df.format(ipi);
		String pisReais = df.format(pis);
		String cofinsReais = df.format(cofins);

		System.out.println("ICMS: R$ " + icmsReais + ";  " + "IPI: R$ " + ipiReais + ";  " + "PIS: R$ " + pisReais
				+ ";  " + "COFINS: R$ " + cofinsReais);
		System.out.println("          ");

		String mercadoriasReais = df.format(totalMercadorias);
		System.out.println("Total Mercadorias: R$ " + mercadoriasReais);
		System.out.println("          ");

		String impostosReais = df.format(totalImpostos);
		System.out.println("Total Impostos: R$ " + impostosReais);
		System.out.println("          ");

		String geralReais = df.format(totalGeral);
		System.out.println("Valor Total Geral: R$ " + geralReais);
		System.out.println("          ");

		if (totalMercadorias >= 2000) {
			
			System.out.println("Cliente ganhou desconto de 10% pela compra a partir de R$ 2.000,00");
			totalMercadoriasDesconto = totalMercadorias - ((totalMercadorias * 10) / 100);

			icmsDesconto = (totalMercadoriasDesconto * 18) / 100;
			ipiDesconto = (totalMercadoriasDesconto * 4) / 100;
			pisDesconto = (totalMercadoriasDesconto * 1.86) / 100;
			cofinsDesconto = (totalMercadoriasDesconto * 8.54) / 100;
			totalImpostosDesconto = icmsDesconto + ipiDesconto + pisDesconto + cofinsDesconto;

			totalGeralDesconto = totalMercadoriasDesconto + totalImpostosDesconto;

			String geralDescontoReais = df.format(totalGeralDesconto);
			System.out.println("          ");
			System.out.println("Total com Desconto ficou R$ " + geralDescontoReais);
		}

	}

}
