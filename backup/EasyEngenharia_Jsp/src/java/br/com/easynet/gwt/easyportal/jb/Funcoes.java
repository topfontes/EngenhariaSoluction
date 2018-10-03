package br.com.easynet.gwt.easyportal.jb;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.NumberFormat;
import java.util.Locale;


public class Funcoes {
        public String aspas(){
		return "\"";
	}
	public static String formatarFloat(String zeros, int numero) {
		String num = zeros + numero;
		return num.substring(num.length() - zeros.length());
	}

	public static String FormatoMoedaBR(float valor){
		java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,##0.00");
		return df.format(valor);
	}

	public static String FormatoMoedaBR_Double(double  valor){
		java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,##0.00");
		return df.format(valor);
	}
        public static String formatoMoeda(float valor)throws Exception{
		//Gera um número aleatório
		double pagamento = valor * 10000;
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		return nf.format(valor).substring(1, nf.format(valor).length());
        }
        public static String formatoMoedaDouble(double valor)throws Exception{
		//Gera um número aleatório
		double pagamento = valor * 10000;
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		return nf.format(valor).substring(1, nf.format(valor).length());
        }
        
	public static int geraFatorDeVencimento(Date dataDeVencimento) {
		Date dataBase = null;
		String Dta_Base = "07/10/1997";
		try {
			dataBase = geraData(Dta_Base);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long diferenca = dataDeVencimento.getTime() - dataBase.getTime();
		return (int) Math.ceil((double) diferenca
				/ (double) (1000 * 60 * 60 * 24));
	}

	public static Date geraData(String data) throws Exception {
		return new SimpleDateFormat("dd/MM/yyyy").parse(data);
	}

	public String tiraSinalValor(String valor) {
		//String vlString = String.valueOf(valor);
		String vlString = valor;
		String novoValor = "";
		for (int i = 0; i < vlString.length(); i++) {
			if (".".equals(vlString.substring(i, i + 1)) || ",".equals(vlString.substring(i, i + 1))) {
			} else {
				novoValor += vlString.substring(i, i + 1);
			}
//			if (vlString.length() - i == 1) {
//				if ("0".equals(vlString.substring(i, i + 1)))
//					novoValor += "0";
//			}
		}
		return novoValor;
	}

	public static Date addDias(Date date, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, dias);
		return calendar.getTime();
	}

	public boolean validacpf(String strCpf) { // formato XXX.XXX.XXX-XX
		if (!strCpf.substring(0, 1).equals("")) {
			try {
				boolean validado = true;
				int d1, d2;
				int digito1, digito2, resto;
				int digitoCPF;
				String nDigResult;
				strCpf = strCpf.replace('.', ' ');
				strCpf = strCpf.replace('-', ' ');
				strCpf = strCpf.replaceAll(" ", "");
				d1 = d2 = 0;
				digito1 = digito2 = resto = 0;

				for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
					digitoCPF = Integer.valueOf(
							strCpf.substring(nCount - 1, nCount)).intValue();

					// multiplique a ultima casa por 2 a seguinte por 3 a
					// seguinte por 4 e assim por diante.
					d1 = d1 + (11 - nCount) * digitoCPF;

					// para o segundo digito repita o procedimento incluindo o
					// primeiro digito calculado no passo anterior.
					d2 = d2 + (12 - nCount) * digitoCPF;
				}
				;

				// Primeiro resto da divis�o por 11.
				resto = (d1 % 11);

				// Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o
				// digito � 11 menos o resultado anterior.
				if (resto < 2)
					digito1 = 0;
				else
					digito1 = 11 - resto;

				d2 += 2 * digito1;

				// Segundo resto da divis�o por 11.
				resto = (d2 % 11);

				// Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o
				// digito � 11 menos o resultado anterior.
				if (resto < 2)
					digito2 = 0;
				else
					digito2 = 11 - resto;

				// Digito verificador do CPF que est� sendo validado.
				String nDigVerific = strCpf.substring(strCpf.length() - 2,
						strCpf.length());

				// Concatenando o primeiro resto com o segundo.
				nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

				// comparar o digito verificador do cpf com o primeiro resto + o
				// segundo resto.
				return nDigVerific.equals(nDigResult);
			} catch (Exception e) {
				System.err.println("Erro !" + e);
				return false;
			}
		} else
			return false;
	}

	public static boolean DataValida(String dateStr)
			throws java.text.ParseException {
		java.text.DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = new GregorianCalendar();

		// gerando o calendar
		cal.setTime(df.parse(dateStr));

		// separando os dados da string para comparacao e validacao
		String[] data = dateStr.split("/");
		String dia = data[0];
		String mes = data[1];
		String ano = data[2];

		// testando se hah discrepancia entre a data que foi
		// inserida no caledar e a data que foi passada como
		// string. se houver diferenca, a data passada era
		// invalida
		if ((new Integer(dia)).intValue() != (new Integer(cal
				.get(Calendar.DAY_OF_MONTH))).intValue()) {
			// dia nao casou
			return (false);
		} else if ((new Integer(mes)).intValue() != (new Integer(cal
				.get(Calendar.MONTH) + 1)).intValue()) {
			// mes nao casou
			return (false);
		} else if ((new Integer(ano)).intValue() != (new Integer(cal
				.get(Calendar.YEAR))).intValue()) {
			// ano nao casou
			return (false);
		}

		return (true);
	}
}
