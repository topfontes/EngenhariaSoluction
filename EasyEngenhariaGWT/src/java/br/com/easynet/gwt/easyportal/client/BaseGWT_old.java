/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client;

import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.json.client.JSONValue;

/**
 *
 * @author marcos
 */
public class BaseGWT_old extends Window {

    private ContentPanel cpTop = new ContentPanel();
    private ContentPanel cpBotton = new ContentPanel();
    private ContentPanel cpMaster = new ContentPanel();
    private ToolBar toolBarMaster = new ToolBar();
    public final static int WIDTH_DEFAULT = 600;
    public final static int HEIGHT_DEFAULT = 400;
    public final static int HEIGHT_DEFAULT_TOP = 100;
    private  BorderLayoutData dataTop = new BorderLayoutData(LayoutRegion.NORTH, 100, 0, 250);
    private BorderLayoutData dataCenter = new BorderLayoutData(LayoutRegion.CENTER);
    private BorderLayoutData dataBotton = new BorderLayoutData(LayoutRegion.SOUTH, 28, 28, 150);

    public BaseGWT_old() {
        
        this.setHeaderVisible(true);
        this.setMinimizable(true);
        this.setMaximizable(true);
        this.setShadow(true);
        this.setSize(WIDTH_DEFAULT+20 , HEIGHT_DEFAULT);
        BorderLayout bl = new BorderLayout();
        this.setLayout(bl);

        dataTop.setCollapsible(true);
        dataTop.setFloatable(true);
        dataCenter.setFloatable(false);

        cpMaster.setButtonAlign(HorizontalAlignment.CENTER);
        cpMaster.setHeaderVisible(true);
        //cpMaster.setHeading("Master Title");
        cpMaster.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT - HEIGHT_DEFAULT_TOP);
        cpMaster.setLayout(new FitLayout());
        cpMaster.setHeaderVisible(false);

        cpTop.setHeaderVisible(true);
        //cpTop.setHeading("Top Title");
        cpTop.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT_TOP);

        cpBotton.setSize(WIDTH_DEFAULT, 28);
        cpBotton.setHeaderVisible(false);
        cpBotton.setButtonAlign(HorizontalAlignment.CENTER);
        //cpBotton.setHeading("Botton Title");
        this.add(toolBarMaster);//marcos
        this.add(cpTop, dataTop);
        this.add(cpMaster, dataCenter);
        this.add(cpBotton,dataBotton);
    }

    public ContentPanel getCpMaster() {
        return cpMaster;
    }

    public void setCpMaster(ContentPanel cpMaster) {
        this.cpMaster = cpMaster;
    }

    public ToolBar getToolBarMaster() {
        return toolBarMaster;
    }

    public void setToolBarMaster(ToolBar toolBarMaster) {
        this.toolBarMaster = toolBarMaster;
    }


    public ContentPanel getCpTop() {
        return cpTop;
    }


    public void setCpTop(ContentPanel cpTop) {
        this.cpTop = cpTop;
    }


    public ContentPanel getCpBotton() {
        return cpBotton;
    }


    public void setCpBotton(ContentPanel cpBotton) {
        this.cpBotton = cpBotton;
    }


    public BorderLayoutData getDataTop() {
        return dataTop;
    }


    public void setDataTop(BorderLayoutData dataTop) {
        this.dataTop = dataTop;
    }

    public BorderLayoutData getDataCenter() {
        return dataCenter;
    }


    public void setDataCenter(BorderLayoutData dataCenter) {
        this.dataCenter = dataCenter;
    }

    public BorderLayoutData getDataBotton() {
        return dataBotton;
    }

    public void setDataBotton(BorderLayoutData dataBotton) {
        this.dataBotton = dataBotton;
    }
}
