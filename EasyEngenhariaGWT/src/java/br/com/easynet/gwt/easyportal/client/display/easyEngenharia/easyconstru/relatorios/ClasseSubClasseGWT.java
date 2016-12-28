/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.relatorios;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Obr_obrasTGWT;
import br.com.easynet.gwt.easyportal.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class ClasseSubClasseGWT extends Window {

    private ListObraGWT listObraGWT = new ListObraGWT();
    private Button exportar = new Button("Exportar");
    private ContentPanel cp = new ContentPanel();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private RelatorioBaseGWT relatorioBaseGWT = new RelatorioBaseGWT();
    private Menu menu = new Menu();

    public ClasseSubClasseGWT() {
        exportar.setIcon(ICONS.download());
        this.setSize(100, 100);
        this.setHeading("Classes e Sub-Claases");
        cp.setHeaderVisible(false);
        //this.add(cp);

        FillLayout layout = new FillLayout();
        
        cp.setLayout(layout);
        montarMenu();
        exportar.setMenu(menu);
        montarTela();
        layout();
    }

    public void montarTela() {
        ToolBar bar = new ToolBar();
        bar.setAlignment(HorizontalAlignment.CENTER);
        bar.add(exportar);
        cp.add(bar);
        cp.setHeight(0);
        add(bar);
        layout();
        //doLayout();

    }

    public void exportarPDF() {
        String url = Constantes.URL + "easyEngenharia/easyconstru/relatorios/classe_subclasses.jsp?op=imprimir&tipo=PDF";
        relatorioBaseGWT.download(url);
    }

    public void exportarXLS() {
        String url = Constantes.URL + "easyEngenharia/easyconstru/relatorios/classe_subclasses.jsp?op=imprimir&tipo=XLS";
        relatorioBaseGWT.download(url);
    }

    public void montarMenu() {
        MenuItem itemPDF = new MenuItem("PDF");
        itemPDF.addSelectionListener(new SelectionListener<MenuEvent>() {

            @Override
            public void componentSelected(MenuEvent ce) {
                exportarPDF();
            }
        });

        MenuItem itemXLS = new MenuItem("XLS");
        itemXLS.addSelectionListener(new SelectionListener<MenuEvent>() {

            @Override
            public void componentSelected(MenuEvent ce) {
                exportarXLS();
            }
        });
        menu.add(itemXLS);
        menu.add(itemPDF);
    }
}
