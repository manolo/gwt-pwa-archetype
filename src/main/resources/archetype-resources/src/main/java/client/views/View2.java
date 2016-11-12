#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.views;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.iron.widget.IronAjax;
import com.vaadin.polymer.iron.widget.IronList;
import com.vaadin.polymer.iron.widget.event.ResponseEvent;
import com.vaadin.polymer.paper.widget.PaperProgress;

public class View2 extends Composite {

  interface View2UiBinder extends UiBinder<HTMLPanel, View2> {}

  private static View2UiBinder viewUi = GWT.create(View2UiBinder.class);

  @UiField IronList list;
  @UiField IronAjax ajax;
  @UiField PaperProgress progress;

  public View2() {
     initWidget(viewUi.createAndBindUi(this));
  }

  @UiHandler("ajax")
  void onResponse(ResponseEvent e) {
    list.setItems(Polymer.<JsArray<?>>property(ajax.getLastResponse(), "items"));
    progress.setVisible(false);
  }

  @Override
  protected void onAttach() {
    super.onAttach();
    if (ajax.getLastResponse() == null) {
      // Introducing a delay to see the progress bar
      Polymer.Base.async(o -> ajax.generateRequest(), 2000);
    }
  }



}
