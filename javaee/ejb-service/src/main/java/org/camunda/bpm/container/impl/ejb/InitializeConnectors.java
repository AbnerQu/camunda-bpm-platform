/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.container.impl.ejb;

import org.camunda.bpm.container.impl.spi.DeploymentOperation;
import org.camunda.bpm.container.impl.spi.DeploymentOperationStep;
import org.camunda.bpm.engine.impl.util.ClassLoaderUtil;
import org.camunda.connect.Connectors;

public class InitializeConnectors extends DeploymentOperationStep {

  @Override
  public String getName() {
    return "Initialize connectors";
  }

  @Override
  public void performOperationStep(DeploymentOperation operationContext) {
    ClassLoader classloader = ClassLoaderUtil.getClassloader(EjbBpmPlatformBootstrap.class);
    Connectors.loadConnectors(classloader);
  }


}
