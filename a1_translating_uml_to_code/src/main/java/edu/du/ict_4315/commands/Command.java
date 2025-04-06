package edu.du.ict_4315.commands;

import java.util.Properties;

public interface Command {
    String getCommandName();
    String getDisplayName();
    String execute(Properties params);
}
