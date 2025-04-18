// Copyright (C) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See LICENSE in project root for information.

package com.microsoft.azure.synapse.ml.nbtest

import com.microsoft.azure.synapse.ml.build.BuildInfo
import com.microsoft.azure.synapse.ml.core.env.FileUtilities
import com.microsoft.azure.synapse.ml.nbtest.DatabricksUtilities._

import java.io.File
import scala.collection.mutable.ListBuffer

class DatabricksGPUTests extends DatabricksTestHelper {

  val clusterId: String = createClusterInPool(GPUClusterName, AdbGpuRuntime, 2, GpuPoolId)

  databricksTestHelper(clusterId, GPULibraries, GPUNotebooks, 1)

  protected override def afterAll(): Unit = {
    afterAllHelper(clusterId, GPUClusterName)
    super.afterAll()
  }

}
