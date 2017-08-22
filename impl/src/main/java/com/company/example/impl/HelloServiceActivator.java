/*
 * Copyright © 2016 BNRC, INC and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.company.example.impl;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.opendaylight.controller.sal.binding.api.AbstractBindingAwareProvider;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;
import org.opendaylight.yang.gen.v1.urn.com.company.example.hello.world.rev150105.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by JingleiPan on 2017/8/22.
 */
public class HelloServiceActivator extends AbstractBindingAwareProvider implements CommandProvider {

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloServiceActivator.class);

    @Override
    public void onSessionInitiated(BindingAwareBroker.ProviderContext providerContext) {
        LOGGER.info("HelloProvider Session fucked.");
        providerContext.addRpcImplementation(HelloWorldService.class, new HelloServiceImpl());
    }

    @Override
    public String getHelp() {
        return "\tgettpsbyne neid– say what you input\n";
    }

    public void _gettpsbyne(CommandInterpreter ci) {
        ci.println("gettpsbyne:" + ci.nextArgument());
    }
}
