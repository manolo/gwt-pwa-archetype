#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.views;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

import com.vaadin.polymer.paper.widget.PaperButton;
import com.vaadin.polymer.paper.widget.PaperInput;
import com.vaadin.polymer.paper.widget.PaperTextarea;
import com.vaadin.polymer.paper.widget.PaperToast;
import com.vaadin.polymer.vaadin.widget.VaadinDatePicker;

public class View3 extends Composite {

  interface View3UiBinder extends UiBinder<HTMLPanel, View3> {
  }

  private static View3UiBinder viewUi = GWT.create(View3UiBinder.class);

  @UiField PaperButton submit;
  @UiField PaperInput title;
  @UiField PaperTextarea descr;
  @UiField VaadinDatePicker date;
  @UiField PaperToast toast;

  public View3() {
    initWidget(viewUi.createAndBindUi(this));
    toast.setFitInto(this.getElement());
  }

  @UiHandler("submit")
  void onClick(ClickEvent e) {
    toast.setText("Date: " + date.getValue() + " Title: " + title.getValue() + " Description: " + descr.getValue());
    toast.open();
  }

}
