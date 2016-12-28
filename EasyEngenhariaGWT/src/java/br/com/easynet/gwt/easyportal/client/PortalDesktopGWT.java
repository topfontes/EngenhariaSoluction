/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client;

import com.extjs.gxt.desktop.client.Desktop;
import com.extjs.gxt.desktop.client.Shortcut;
import com.extjs.gxt.desktop.client.StartMenu;
import com.extjs.gxt.desktop.client.TaskBar;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.json.client.JSONValue;

/**
 *
 * @author geoleite
 */
public class PortalDesktopGWT {

    private Desktop desktop;
    private MenuGWT menu;
    /**
     * The entry point method, called automatically by loading a module
     * that declares an implementing class as an entry-point
     */
    public void PortalDesktopGWT() {

    }


    public void gerarMenu(Desktop desktopTemp) {
        desktop = desktopTemp;          
        SelectionListener<ComponentEvent> listener = new SelectionListener<ComponentEvent>() {

            @Override
            public void componentSelected(ComponentEvent ce) {
                Window w = null;
                if (ce instanceof MenuEvent) {
                    MenuEvent me = (MenuEvent) ce;
                    w = me.getItem().getData("window");
                } else {
                    w = ce.getComponent().getData("window");
                }
                if (!desktop.getWindows().contains(w)) {
                    desktop.addWindow(w);
                }
                if (w != null && !w.isVisible()) {
                    w.show();
                } else {
                    w.toFront();
                }
            }
        };

        TaskBar taskBar = desktop.getTaskBar();
        StartMenu menu = taskBar.getStartMenu();
        menu.setHeading("EasyPortal System");
        menu.setIconStyle("user");

    }


    /**
     * Cria a janela home com o conteudo
     * @return
     *
    private Window getWindowHome() {
        Window w = new Window();
        w.setCloseAction(Window.CloseAction.CLOSE);
        w.setIconStyle("icon-grid");
        w.setMinimizable(true);
        w.setMaximizable(true);
        w.setHeading("Home");
        w.setSize(500, 400);
        String str = "Site pessoal de George Leite Junior";
        Text text = new Text(str);
        text.setStyleName("topico1");
        w.add(text);

        str = "\"O fracasso é a oportunidade de se começar de novo, com inteligência.\" Henry Ford";
        text = new Text(str);
        text.setStyleName("texto");
        w.add(text);

        w.add(new Text("                                                                                                                                                                     "));

        str = "\"Falta de tempo é desculpa daqueles que perdem tempo por falta de métodos.\"Albert Einstein";
        text = new Text(str);
        text.setStyleName("texto");
        w.add(text);

        return w;
    }

    private Window getProdutos() {
        Window w = new Window();
        w.setCloseAction(Window.CloseAction.CLOSE);
        w.setIconStyle("produto");
        w.setResizable(false);
        w.setMinimizable(true);
        w.setMaximizable(true);
        w.setHeading("Softwares Desenvolvidos");
        w.setSize(500, 400);
        w.setLayout(new AccordionLayout());

        ContentPanel cpProfessor = new ContentPanel();
        cpProfessor.setLayout(new RowLayout(Orientation.VERTICAL));
        cpProfessor.setScrollMode(Scroll.AUTO);
        //cpProfessor.getHeader().addTool(new ToolButton("x-tool-refresh"));


        cpProfessor.setHeading("EasyNet FrameWork");

        Text text = new Text("Framework de desenvolvimento java capaz de aumentar a organizacao no desenvolvimento de aplicacoes como tambem capaz de gerar codigo baseado nas tabelas do banco de dados.");
        text.setStyleName("texto");
        cpProfessor.add(text);

        Hyperlink link = new Hyperlink("Download", "_blank");
        link.addClickListener(new ClickListener() {

            public void onClick(Widget sender) {
                execute("window.open ('http://geoleite.zante.uni5.net/easynet/distribuicao_easynet.zip','mywindow');");
            }
        });
        //text.setStyleName("texto");
        cpProfessor.add(link);

        w.add(cpProfessor);

        ContentPanel cpCurso = new ContentPanel();
        cpCurso.setLayout(new RowLayout(Orientation.VERTICAL));
        cpCurso.setScrollMode(Scroll.AUTO);
        cpCurso.setHeading("VirtualScreen");

        text = new Text("Sistema para auxilio do professor no momento das aulas, transmitindo sua tela para as maquinas dos alunos.");
        text.setStyleName("texto");
        cpCurso.add(text);
        w.add(cpCurso);

        ContentPanel cpHorario = new ContentPanel();
        cpHorario.setLayout(new RowLayout(Orientation.VERTICAL));
        cpHorario.setScrollMode(Scroll.AUTO);
        cpHorario.setHeading("EasyClin");

        text = new Text("Sistema de Gerenciamento de Clinicas Medicas, Odontologicas entre outras e Financeiro.");
        text.setStyleName("texto");
        cpHorario.add(text);
        w.add(cpHorario);

        ContentPanel cpInvestimento = new ContentPanel();
        cpInvestimento.setLayout(new RowLayout(Orientation.VERTICAL));
        cpInvestimento.setScrollMode(Scroll.AUTO);
        cpInvestimento.setHeading("EasyForum");

        text = new Text("Sistema gratuito para Forum desenvolvido utilizando o framework EasyNet.");
        text.setStyleName("texto");
        cpInvestimento.add(text);
        w.add(cpInvestimento);

        ContentPanel cpDataLocal = new ContentPanel();
        cpDataLocal.setLayout(new RowLayout(Orientation.VERTICAL));
        cpDataLocal.setScrollMode(Scroll.AUTO);
        cpDataLocal.setHeading("EasyCondominium");

        text = new Text("Sistema para gerenciamento de condominio com varios perfis de acesso (Contador, Sindico, Morador  e Funcionario) Integrado ao sistema financeiro.");
        text.setStyleName("texto");
        cpDataLocal.add(text);

        text = new Text("Local:Crabzy Treinamentos e Consultoria, localizado proíxmo ao Colégio Arqui. Rua Senador Rollemberg, 561, São José (próximo a antiga LBA na rua Santa Luzia).");
        text.setStyleName("texto");
        cpDataLocal.add(text);
        w.add(cpDataLocal);


        return w;
    }

    private Window getCurso() {
        Window w = new Window();
        w.setCloseAction(Window.CloseAction.CLOSE);
        w.setIconStyle("bogus");
        w.setResizable(false);
        w.setMinimizable(true);
        w.setMaximizable(true);
        w.setHeading("Curso");
        w.setSize(500, 400);
        w.setLayout(new AccordionLayout());

        ContentPanel cpProfessor = new ContentPanel();
        cpProfessor.setLayout(new RowLayout(Orientation.VERTICAL));
        cpProfessor.setScrollMode(Scroll.AUTO);
        //cpProfessor.getHeader().addTool(new ToolButton("x-tool-refresh"));


        cpProfessor.setHeading("Dados do Professor");

        Text text = new Text("Nome: George Leite Junior");
        text.setStyleName("texto");
        cpProfessor.add(text);

        text = new Text("Fone: (79) 9191-9135");
        text.setStyleName("texto");
        cpProfessor.add(text);

        text = new Text("Email: geoleite@hotmail.com");
        text.setStyleName("texto");
        cpProfessor.add(text);

        Hyperlink link = new Hyperlink("Curriculo: Lattes", "_blank");

        link.addClickListener(new ClickListener() {

            public void onClick(Widget sender) {
                execute("window.open ('http://buscatextual.cnpq.br/buscatextual/visualizacv.jsp?id=K4731767J6','mywindow');");
            }
        });
        //text.setStyleName("texto");
        cpProfessor.add(link);

        w.add(cpProfessor);

        ContentPanel cpCurso = new ContentPanel();
        cpCurso.setLayout(new RowLayout(Orientation.VERTICAL));
        cpCurso.setScrollMode(Scroll.AUTO);
        cpCurso.setHeading("Ementa do Curso");

        text = new Text("Introdução à Plataforma Java");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Estrutura da linguagem");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Orientação a objetos (Herança, Encapsulamento e Polimorfismo )");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Coleções");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Introdução a Sistema Gerenciador de Banco de Dados (SGBD)");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Comandos básicos em banco de dados");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Introdução ao HTML");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Introdução ao Servlet e Java ServerPages (JSP)");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Criando páginas dinâmicas com JSP");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Comandos: scritlets, expressões, declarações e linguagem de expressão");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Introdução à JavaBean");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Introdução à JavaScript");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Arquitetura de desenvolvimento aberto com o Framework EasyNet");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Programação orientado a eventos na Web");
        text.setStyleName("texto");
        cpCurso.add(text);

        text = new Text("Introdução ao Java ServerFaces (JSF)");
        text.setStyleName("texto");
        cpCurso.add(text);
        w.add(cpCurso);

        ContentPanel cpHorario = new ContentPanel();
        cpHorario.setLayout(new RowLayout(Orientation.VERTICAL));
        cpHorario.setScrollMode(Scroll.AUTO);
        cpHorario.setHeading("Horario e Carga Horaria do Curso");

        text = new Text("O curso possui duracao de 40 horas aos Sábados  das 08:00 às 13:00.");
        text.setStyleName("texto");
        cpHorario.add(text);
        w.add(cpHorario);

        ContentPanel cpInvestimento = new ContentPanel();
        cpInvestimento.setLayout(new RowLayout(Orientation.VERTICAL));
        cpInvestimento.setScrollMode(Scroll.AUTO);
        cpInvestimento.setHeading("Investimento");

        text = new Text("R$ 350,00 podendo ser divido em duas vezes no cheque.");
        text.setStyleName("texto");
        cpInvestimento.add(text);
        w.add(cpInvestimento);

        ContentPanel cpDataLocal = new ContentPanel();
        cpDataLocal.setLayout(new RowLayout(Orientation.VERTICAL));
        cpDataLocal.setScrollMode(Scroll.AUTO);
        cpDataLocal.setHeading("Data do Inicio e local");

        text = new Text("Inicio previsto: 25/04/2009.");
        text.setStyleName("texto");
        cpDataLocal.add(text);

        text = new Text("Local:Crabzy Treinamentos e Consultoria, localizado proíxmo ao Colégio Arqui. Rua Senador Rollemberg, 561, São José (próximo a antiga LBA na rua Santa Luzia).");
        text.setStyleName("texto");
        cpDataLocal.add(text);
        w.add(cpDataLocal);

        ContentPanel cpInscricao = new ContentPanel();
        cpInscricao.setLayout(new RowLayout(Orientation.VERTICAL));
        cpInscricao.setScrollMode(Scroll.AUTO);
        cpInscricao.setHeading("Inscricao");

        text = new Text("Nome:");
        text.setStyleName("texto");
        cpInscricao.add(text);
        final TextField tfNome = new TextField();
        cpInscricao.add(tfNome);
        text = new Text("Email:");
        text.setStyleName("texto");
        cpInscricao.add(text);
        final TextField tfEmail = new TextField();
        cpInscricao.add(tfEmail);
        Button btnInscricao = new Button("Enviar");
        cpInscricao.addButton(btnInscricao);
        btnInscricao.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                try {
                    //Info.display("Event", "Inscricao efetuada com sucesso!");
                    MainEntryPoint emp = new MainEntryPoint();
                    EasyAccessURL eaurl = new EasyAccessURL(emp);
                    String url = "/inscricao.jsp";
                    HashMap<String, String> param = new HashMap<String, String>();
                    param.put("op", "insert");
                    param.put("alu_alunoT.alu_tx_nome", tfNome.getValue() + "");
                    param.put("alu_alunoT.alu_tx_email", tfEmail.getValue() + "");
                    param.put("alu_alunoT.alu_tx_obs", "Inscricao via GWT");
                    eaurl.accessJSonMap(url, param);
                } catch (Exception ex) {

                }
            }
        });
        w.add(cpInscricao);
        return w;
    }

    private Window getContato() {
        Window w = new Window();
        w.setCloseAction(Window.CloseAction.CLOSE);
        w.setIconStyle("contato");
        w.setResizable(false);
        w.setMinimizable(true);
        w.setMaximizable(false);
        w.setHeading("Contato");
        w.setSize(300, 200);

        Text text = new Text("Email para retorno:");
        text.setStyleName("texto");
        TextField tf = new TextField();
        tf.setSize(275, 20);
        w.add(text);
        w.add(tf);
        text = new Text("Texto da Mensagem: ");
        text.setStyleName("texto");
        TextArea ta = new TextArea();
        ta.setSize(275, 85);
        w.add(text);
        w.add(ta);
        Button btnEnviar = new Button("Enviar");
        btnEnviar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                Info.display("Event", "Enviando mensagem ao administrador!");
            }
        });
        w.addButton(btnEnviar);
        return w;
    }

    public native static void execute(String command)/*-{
        eval(command);
    }-*/;

    public void read(JSONValue jsonValue) {

    }
    public void readString(String dados) {
        Info.display("Event", "Inscricao efetuada com sucesso!");
    }

    /**
     * @return the desktop
     */
    public Desktop getDesktop() {
        return desktop;
    }

    /**
     * @param desktop the desktop to set
     */
    public void setDesktop(Desktop desktop) {
        this.desktop = desktop;
    }
}
