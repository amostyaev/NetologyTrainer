package com.raistlin.netologysample

import com.raistlin.netologysample.logic.parseThemes
import org.junit.Assert.assertEquals
import org.junit.Test

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
        val themes = parseThemes("""{"data":[]}""")
        assertEquals(0, themes.size)
    }

    @Test
    fun parseEmptyGroupsTest() {
        val themes = parseThemes("""{"data":["groups":[]]}""")
        assertEquals(0, themes.size)
    }

    @Test
    fun parseSingleGroupTest() {
        val themes = parseThemes(
            """{"data":[{"groups":[
                          {
                             "id":"159bf7c0-c5cf-4b75-8f59-fdf2b33291d3",
                             "link":"",
                             "badge":{
                                "text":"НЕО",
                                "color":"#47C397",
                                "bgColor":"#EDFBF6"
                             },
                             "items":[
                                {
                                   "id":"040ed0e8-58f7-4bf8-95ad-2c7d130fac52",
                                   "link":"/programs/landing-pages",
                                   "badge":{
                                      "text":"",
                                      "color":"#FFF",
                                      "bgColor":"#E04D7E"
                                   },
                                   "title":"Создание лендингов"
                                }
                             ],
                             "title":"Для начинающих"
                          },
                          {
                             "id":"009af6f1-cde6-4899-929c-d89077cd862f",
                             "link":"",
                             "badge":{
                                "text":"ПРО",
                                "color":"#0066FF",
                                "bgColor":"#E6F0FF"
                             },
                             "items":[
                                {
                                   "id":"28371a1d-2b18-4ed1-a6dd-a94d5626d4c4",
                                   "link":"/programs/marketing-director",
                                   "badge":{
                                      "text":"",
                                      "color":"#FFF",
                                      "bgColor":"#E04D7E"
                                   },
                                   "title":"Директор по интернет-маркетингу"
                                },
                                {
                                   "id":"02bb3e6e-2b69-4951-9dea-397db388df58",
                                   "link":"/programs/smmpro#/",
                                   "badge":{
                                      "text":"",
                                      "color":"#FFF",
                                      "bgColor":"#E04D7E"
                                   },
                                   "title":"SMM для PRO"
                                }
                             ],
                             "title":"Для профи"
                          },
                          {
                             "id":"9a596283-6ad2-4e4d-b948-519b4935709e",
                             "link":"",
                             "badge":{
                                "text":"",
                                "color":"#FFF",
                                "bgColor":"#E04D7E"
                             },
                             "items":[
                             
                             ],
                             "title":"Для руководителей"
                          }
                       ],
                       "direction":{
                          "id":"2325581d-b12f-4989-b7e9-9a6e7c401673",
                          "link":"/marketing",
                          "badge":{
                             "text":"",
                             "color":"#FFF",
                             "bgColor":"#E04D7E"
                          },
                          "title":"Маркетинг"
                       }}]}"""
        )
        assertEquals(1, themes.size)
        val theme = themes[0]
        assertEquals("Маркетинг", theme.title)
        assertEquals(3, theme.courses)
        assertEquals("#E04D7E", theme.color)
    }

}