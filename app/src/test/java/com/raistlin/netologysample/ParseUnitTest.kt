package com.raistlin.netologysample

import com.raistlin.netologysample.logic.parseThemes
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ParseUnitTest {

    @Test
    fun parseEmptyStringTest() {
        val themes = parseThemes("")
        assertEquals(0, themes.size)
    }

    @Test
    fun parseEmptyJSONTest() {
        val themes = parseThemes("{}")
        assertEquals(0, themes.size)
    }

    @Test
    fun parseEmptyDataTest() {
        val themes = parseThemes("{\"data\":[]}")
        assertEquals(0, themes.size)
    }

    @Test
    fun parseEmptyGroupsTest() {
        val themes = parseThemes("{\"data\":[\"groups\":[]]}")
        assertEquals(0, themes.size)
    }

    @Test
    fun parseSingleGroupTest() {
        val themes = parseThemes("{\"data\":[{\"groups\":[\n" +
                "            {\n" +
                "               \"id\":\"159bf7c0-c5cf-4b75-8f59-fdf2b33291d3\",\n" +
                "               \"link\":\"\",\n" +
                "               \"badge\":{\n" +
                "                  \"text\":\"НЕО\",\n" +
                "                  \"color\":\"#47C397\",\n" +
                "                  \"bgColor\":\"#EDFBF6\"\n" +
                "               },\n" +
                "               \"items\":[\n" +
                "                  {\n" +
                "                     \"id\":\"040ed0e8-58f7-4bf8-95ad-2c7d130fac52\",\n" +
                "                     \"link\":\"/programs/landing-pages\",\n" +
                "                     \"badge\":{\n" +
                "                        \"text\":\"\",\n" +
                "                        \"color\":\"#FFF\",\n" +
                "                        \"bgColor\":\"#E04D7E\"\n" +
                "                     },\n" +
                "                     \"title\":\"Создание лендингов\"\n" +
                "                  }\n" +
                "               ],\n" +
                "               \"title\":\"Для начинающих\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"id\":\"009af6f1-cde6-4899-929c-d89077cd862f\",\n" +
                "               \"link\":\"\",\n" +
                "               \"badge\":{\n" +
                "                  \"text\":\"ПРО\",\n" +
                "                  \"color\":\"#0066FF\",\n" +
                "                  \"bgColor\":\"#E6F0FF\"\n" +
                "               },\n" +
                "               \"items\":[\n" +
                "                  {\n" +
                "                     \"id\":\"28371a1d-2b18-4ed1-a6dd-a94d5626d4c4\",\n" +
                "                     \"link\":\"/programs/marketing-director\",\n" +
                "                     \"badge\":{\n" +
                "                        \"text\":\"\",\n" +
                "                        \"color\":\"#FFF\",\n" +
                "                        \"bgColor\":\"#E04D7E\"\n" +
                "                     },\n" +
                "                     \"title\":\"Директор по интернет-маркетингу\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"id\":\"02bb3e6e-2b69-4951-9dea-397db388df58\",\n" +
                "                     \"link\":\"/programs/smmpro#/\",\n" +
                "                     \"badge\":{\n" +
                "                        \"text\":\"\",\n" +
                "                        \"color\":\"#FFF\",\n" +
                "                        \"bgColor\":\"#E04D7E\"\n" +
                "                     },\n" +
                "                     \"title\":\"SMM для PRO\"\n" +
                "                  }\n" +
                "               ],\n" +
                "               \"title\":\"Для профи\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"id\":\"9a596283-6ad2-4e4d-b948-519b4935709e\",\n" +
                "               \"link\":\"\",\n" +
                "               \"badge\":{\n" +
                "                  \"text\":\"\",\n" +
                "                  \"color\":\"#FFF\",\n" +
                "                  \"bgColor\":\"#E04D7E\"\n" +
                "               },\n" +
                "               \"items\":[\n" +
                "                  \n" +
                "               ],\n" +
                "               \"title\":\"Для руководителей\"\n" +
                "            }\n" +
                "         ],\n" +
                "         \"direction\":{\n" +
                "            \"id\":\"2325581d-b12f-4989-b7e9-9a6e7c401673\",\n" +
                "            \"link\":\"/marketing\",\n" +
                "            \"badge\":{\n" +
                "               \"text\":\"\",\n" +
                "               \"color\":\"#FFF\",\n" +
                "               \"bgColor\":\"#E04D7E\"\n" +
                "            },\n" +
                "            \"title\":\"Маркетинг\"\n" +
                "         }}]}")
        assertEquals(1, themes.size)
        val theme = themes[0]
        assertEquals(theme.title, "Маркетинг")
        assertEquals(theme.courses, 3)
        assertEquals(theme.color, "#E04D7E")
    }

}