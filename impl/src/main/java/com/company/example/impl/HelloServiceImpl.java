/*
 * Copyright © 2016 BNRC, INC and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.company.example.impl;

import org.opendaylight.yang.gen.v1.urn.com.company.example.hello.world.rev150105.HelloInput;
import org.opendaylight.yang.gen.v1.urn.com.company.example.hello.world.rev150105.HelloOutput;
import org.opendaylight.yang.gen.v1.urn.com.company.example.hello.world.rev150105.HelloOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.com.company.example.hello.world.rev150105.HelloWorldService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;

import java.util.concurrent.Future;


/**
 * Created by JingleiPan on 2017/8/21.
 */
public class HelloServiceImpl implements HelloWorldService{

    @Override
    public Future<RpcResult<HelloOutput>> hello(HelloInput input) {
        HelloOutputBuilder helloBuilder = new HelloOutputBuilder();
        helloBuilder.setGreeting("Hello , " + input.getName());
        return RpcResultBuilder.success(helloBuilder.build()).buildFuture();
    }
}
