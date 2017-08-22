/*
 * Copyright © 2016 BNRC, INC and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.company.example.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.com.company.example.hello.world.rev150105.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldProvider {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldProvider.class);

    private final DataBroker dataBroker;
    private final RpcProviderRegistry rpcProviderRegistry;
    RpcRegistration<HelloWorldService> helloWorldServiceRpcRegistration;

    public HelloWorldProvider(final DataBroker dataBroker, RpcProviderRegistry rpcProviderRegistry) {
        this.dataBroker = dataBroker;
        this.rpcProviderRegistry = rpcProviderRegistry;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("Hello-worldProvider Session Initiated");
        helloWorldServiceRpcRegistration = rpcProviderRegistry.addRpcImplementation(HelloWorldService.class, new HelloServiceImpl());
    }


    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
        LOG.info("Hello-worldProvider Closed");
        helloWorldServiceRpcRegistration.close();
    }
}