package com.module.tests

import com.module.core.Module

import kotlin.test.Test
import kotlin.test.assertEquals

class ModuleTest {
    @Test fun testModule() {
        val module = Module(2)
        assertEquals(2, module.get(), "Module get should return 2")
    }
}
