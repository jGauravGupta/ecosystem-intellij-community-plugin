/*
 * Copyright (c) 2020 Payara Foundation and/or its affiliates and others.
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
package fish.payara.qube;

import fish.payara.qube.maven.QubeMavenConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import static fish.payara.PayaraConstants.QUBE_ICON;

public class PayaraQubeConfigurationType implements ConfigurationType {

    @NotNull
    @Override
    public String getDisplayName() {
        return "Payara Qube";
    }

    @Override
    public String getConfigurationTypeDescription() {
        return "Payara Qube configuration type";
    }

    @Override
    public Icon getIcon() {
        return QUBE_ICON;
    }

    @NotNull
    @Override
    public String getId() {
        return "PAYARA_QUBE_CONFIGURATION";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{
            new QubeMavenConfigurationFactory(this)
        };
    }
}
