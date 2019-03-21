package plugin.plugins.plugin1;

import plugin.Plugin;

public class PluginImpl implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Plugin "+getClass().getName());
    }
}
