/*
 * Copyright (c) 2024 Payara Foundation and/or its affiliates and others.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package fish.payara.cloud.actions;


import com.intellij.openapi.ui.Messages;
import com.intellij.terminal.JBTerminalWidget;
import fish.payara.cloud.PayaraCloudProject;
import fish.payara.cloud.maven.CloudMavenProject;
import static java.util.logging.Level.WARNING;
import java.util.logging.Logger;

/**
 *
 * @author gaurav.gupta@payara.fish
 */
public class CloudListNamespaceAction extends CloudAction {

    private static final Logger LOG = Logger.getLogger(CloudListNamespaceAction.class.getName());

    @Override
    public void onAction(PayaraCloudProject project) {
        String projectName;
        projectName = project.getProjectName();
        JBTerminalWidget terminal = getTerminal(project.getProject(), projectName);
        if (terminal != null) {
            String subscriptionValue = Messages.showInputDialog(
                project.getProject(),
                "Subscription:",
                "List Cloud Namespaces",
                Messages.getQuestionIcon()
            );
            if (subscriptionValue != null && !subscriptionValue.trim().isEmpty()) {
                executeCommand(terminal, project.getNamespaceCommand() + " -D" + CloudMavenProject.SUBSCRIPTION_ATTR + "='" + subscriptionValue + "'");
            } else {
                executeCommand(terminal, project.getNamespaceCommand());
            }
        } else {
            LOG.log(WARNING, "Shell window for {0} is not available.", projectName);
        }
    }

}
