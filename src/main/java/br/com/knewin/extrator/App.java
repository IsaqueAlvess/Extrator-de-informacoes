package br.com.knewin.extrator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {

	private Document document;
	
	public App(Document document) {
		this.document = document;
	}
	
	public static void main(String[] args) {
			
		List<String> URLs = new ArrayList<String>();	//Lista de URLs das páginas 1,2 e 3 
						 
		try {
			
			URLs = getListaURLs();
			URLs.addAll(getListaURLsPag2());
			URLs.addAll(getListaURLsPag3());
			
			for(String url : URLs) {
				System.out.println(url);
			}
			
			for(String url : URLs) {
				Document document = Jsoup.connect(url).get();
				
				App parserInfo = new App(document);
				parserInfo.getInfo(url);
			}		
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}			
		
	}
	
	//Conexão da página 2 utilizando Método POST 
	public static List<String> getListaURLsPag2() {
		
		List<String> URLs = new ArrayList<String>();
		
		 try {
			 
			 Document document = Jsoup.connect("https://www.infomoney.com.br/mercados/?infinity=scrolling")
			.header("	Content-Type	" , "application/x-www-form-urlencoded; charset=UTF-8")
			.header("X-Requested-With","XMLHttpRequest")
			.header("Accept", " */* ")
			.header("	Accept-Encoding	" , "	gzip, deflate, br")
			.header("	Accept-Language	" , "	en-US,en;q=0.5")
			.header("	Connection	" , "	keep-alive")
			.header("	Content-Length	" , "	3520	")
			.header("	Host	" , "	www.infomoney.com.br")
			.header("	Origin	" , "	https://www.infomoney.com.br")
			.header("	Referer	" , "	https://www.infomoney.com.br/mercados/")
			.header("	Sec-Fetch-Dest	" , "	empty	")
			.header("	Sec-Fetch-Mode	" , "	cors	")
			.header("	Sec-Fetch-Site	" , "	same-origin	")
			.header("	TE	" , "	trailers	")
			.header("	User-Agent	" , "	Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:90.0) Gecko/20100101 Firefox/90.0	")
			.header("	X-Requested-With	" , "	XMLHttpRequest	")
			.cookie("	__gads	",	"ID=cac347f4ea00c827-22e6985cd7b30077:T=1623028684:S=ALNI_Mb08vi05DvJ9rNX40VI7XTtkDZxtg")
			.cookie("	_ga	","GA1.3.664574251.1623028681")
			.cookie("	_gasessionid",	"20210607044333681623112196534"	)
			.cookie("	cto_bundle	","4F9X119TZnBnTyUyQjlUUG5HVjBrZVJUY2h0STAyczU1SHZYUUIzUTJXc1JXSldjQ1lpRTBRVjRlVzFYbGZiTFVBVFZJcHJsOUJFSUVCJTJGZUUxcVhzQmVGV3lMMGQyWUJxaDJnZ0t4YkZ1MVFINGdlaU0lMkJXcDVqVzJLdHdsY2U2U2VBNlFnUDZocDBIR2E1bmJJTEoxa1VGT0NiYkElM0QlM0Q")
			.data("action","infinite_scroll")
			.data("page","2")
			.data("currentday","")
			.data("charset","UTF-8")
			.data("order","DESC")
			.ignoreContentType(true)
			.post();
			 
			App parserInfo = new App(document);
			parserInfo.document.append(document.html());
					
			URLs= parserInfo.getURLInfoPagePost();	

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return URLs;
	}
	
	//Conexão da página 3 utilizando método POST 
	public static List<String> getListaURLsPag3() {
		
		List<String> URLs = new ArrayList<String>();
		
		 try {
			 
			 Document document = Jsoup.connect("https://www.infomoney.com.br/mercados/?infinity=scrolling")
			.header("	Content-Type	" , "application/x-www-form-urlencoded; charset=UTF-8")
			.header("X-Requested-With","XMLHttpRequest")
			.header("Accept", " */* ")
			.header("	Accept-Encoding	" , "	gzip, deflate, br")
			.header("	Accept-Language	" , "	en-US,en;q=0.5")
			.header("	Connection	" , "	keep-alive")
			.header("	Content-Length	" , "	3520	")
			.header("	Host	" , "	www.infomoney.com.br")
			.header("	Origin	" , "	https://www.infomoney.com.br")
			.header("	Referer	" , "	https://www.infomoney.com.br/mercados/")
			.header("	Sec-Fetch-Dest	" , "	empty	")
			.header("	Sec-Fetch-Mode	" , "	cors	")
			.header("	Sec-Fetch-Site	" , "	same-origin	")
			.header("	TE	" , "	trailers	")
			.header("	User-Agent	" , "	Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:90.0) Gecko/20100101 Firefox/90.0	")
			.header("	X-Requested-With	" , "	XMLHttpRequest	")
			.cookie("	__gads	",	"ID=cac347f4ea00c827-22e6985cd7b30077:T=1623028684:S=ALNI_Mb08vi05DvJ9rNX40VI7XTtkDZxtg")
			.cookie("	_ga	","GA1.3.664574251.1623028681")
			.cookie("	_gasessionid",	"20210607044333681623112196534"	)
			.cookie("	cto_bundle	","4F9X119TZnBnTyUyQjlUUG5HVjBrZVJUY2h0STAyczU1SHZYUUIzUTJXc1JXSldjQ1lpRTBRVjRlVzFYbGZiTFVBVFZJcHJsOUJFSUVCJTJGZUUxcVhzQmVGV3lMMGQyWUJxaDJnZ0t4YkZ1MVFINGdlaU0lMkJXcDVqVzJLdHdsY2U2U2VBNlFnUDZocDBIR2E1bmJJTEoxa1VGT0NiYkElM0QlM0Q")
			.data("action","infinite_scroll")
			.data("page","3")
			.data("currentday","")
			.data("charset","UTF-8")
			.data("order","DESC")
			.ignoreContentType(true)
			.post();
			 
			App parserInfo = new App(document);
			parserInfo.document.append(document.html());
					
			URLs= parserInfo.getURLInfoPagePost();	

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return URLs;
	}

	//Função que passa os elementos da página como parâmetro
	public List<String> getURLInfoPagePost() {
		Elements elements = document.getAllElements();
		return getURLPagesPost(elements.eq(0));
	}
	
	//Função que devolve a URL das páginas que fazem requisição com método POST
	public List<String> getURLPagesPost(Elements elements) {
		
		List<String> URLs = new ArrayList<String>();		
		for(Element element : elements) {
			
			Elements children = element.getElementsByTag("a");
			for(Element a : children) {
			
				String url = formataDados(a.getElementsByTag("a").attr("href").toString());
				
				if(! URLs.contains(url)) {
					URLs.add(url);
				}
			}	
		}
		return URLs;
	}

	//Função de formatação de dados de parametros recebidos
	public static String formataDados(String dados){
		
		dados = dados.replaceAll("\\&quot;" , "");
		dados = dados.replace("\\","");				
		dados = dados.replace('"',' ');
		return dados;
	}
	

	//INFORMAÇÃO DE CADA PÁGINA
	private void getInfo(String URL) {
		Elements elements = document.getElementsByClass("container");	//col-md-10 col-xl-8 m-auto
		
		getInfoPage(elements.eq(2),URL);
	}
	//INFORMAÇÃO DE CADA PÁGINA
	private void getInfoPage(Elements elements, String URL) {
	
		for (Element element : elements) {
			
			String titulo = element.getElementsByClass("page-title-1").text();
			String subTitulo = element.getElementsByClass("article-lead").text();
			String autor = element.getElementsByClass("author-name").text();
			String dataPublicacao = element.getElementsByClass("entry-date published").text();
			String conteudo="";
			Elements children = element.getElementsByTag("p");
			for(Element p : children) {
				conteudo += p.getElementsByTag(" p ").text();
			}
			
			System.out.println("URL: "+URL+"\nTítulo: "+titulo+"\nSubTitulo: "+subTitulo+"\nAutor: "+autor+"\nData Publicação: "+dataPublicacao+"\nConteúdo: "+conteudo+"\n\n\n");
		}
		
	}
	
	
	//Função que pega as URLs da página 1
	public static List<String> getListaURLs() {
		
		List<String> URLs = new ArrayList<String>();
		
		 try {
			Document document = Jsoup.connect("https://www.infomoney.com.br/mercados/").get();
			
			App parserInfo = new App(document);
			URLs = parserInfo.getURLInfo();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return URLs;
	}

	//Função que passa os elementos da página como parâmetro
	public List<String> getURLInfo() {
		Elements elements = document.getElementsByClass("row");
		return getURLPages(elements.eq(7));
	}

	//Função que pega as URLs da página 1
	public List<String> getURLPages(Elements elements) {
		
		List<String> URLs = new ArrayList<String>();
		int i = 0;
		
		for(Element element : elements) {
			
			Elements children = element.getElementsByTag("a");
			for(Element a : children) {
				
				if((i!=0) && (a.getElementsByTag("a").attr("href").equals(URLs.get(i-1)))) {
					continue;
				}else {
					URLs.add(a.getElementsByTag("a").attr("href"));
				}
				i++;
			}
		}
		
		return URLs;
	}

	
}

