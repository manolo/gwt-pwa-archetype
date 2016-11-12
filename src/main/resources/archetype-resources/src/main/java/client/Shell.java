#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import ${package}.client.views.*;

import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.app.widget.AppDrawer;
import com.vaadin.polymer.iron.widget.event.IronSelectEvent;
import com.vaadin.polymer.paper.widget.PaperMenu;

import java.util.Arrays;

public class Shell extends Composite implements EntryPoint {

  interface ShellWidgetsUiBinder extends UiBinder<HTMLPanel, Shell> {}

  private static ShellWidgetsUiBinder shellUi = GWT.create(ShellWidgetsUiBinder.class);

  @UiField PaperMenu menu;
  @UiField SimplePanel content;
  @UiField AppDrawer drawer;

  private Widget[] views = new Widget[3];

  @Override
  public void onModuleLoad() {
    // Initialize the UI
    initWidget(shellUi.createAndBindUi(this));

    // Check that polyfill has been loaded if needed
    Polymer.whenReady(o1 -> {

      // Manually Import some components
      Polymer.importHref(Arrays.asList("paper-styles", "iron-icons"), o -> {

        // Attach the Ui.
        RootPanel.get().add(this);

        // FIXME: figure out why Chrome needs this
        Polymer.Base.async(o2 -> ${symbol_dollar}(window).trigger("resize"), 500);
        Polymer.Base.async(o2 -> ${symbol_dollar}(window).trigger("resize"), 1000);

        return 0;
      });
      return 0;

    });
  }

  @UiHandler("menu")
  void onMenuSelect(IronSelectEvent e) {
    if (!drawer.getPersistent()) {
      drawer.close();
    }

    int idx = Integer.parseInt(menu.getSelected().toString());
    content.setWidget(getView(idx));
  }

  // Lazy creation of views
  private Widget getView(int idx) {
    return views[idx] = views[idx] == null ? createView(idx) : views[idx];
  }

  // Define here all your views
  private Widget createView(int idx) {
    switch (idx) {
      case 0: return new View1();
      case 1: return new View2();
      case 2: return new View3();
      default: return null;
    }
  }
}
