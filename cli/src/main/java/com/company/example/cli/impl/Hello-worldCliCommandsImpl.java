/*
 * Copyright © 2016 BNRC, INC and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.company.example.cli.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.company.example.cli.api.Hello-worldCliCommands;

public class Hello-worldCliCommandsImpl implements Hello-worldCliCommands {

    private static final Logger LOG = LoggerFactory.getLogger(Hello-worldCliCommandsImpl.class);
    private final DataBroker dataBroker;

    public Hello-worldCliCommandsImpl(final DataBroker db) {
        this.dataBroker = db;
        LOG.info("Hello-worldCliCommandImpl initialized");
    }

    @Override
    public Object testCommand(Object testArgument) {
        return "This is a test implementation of test-command";
    }
}