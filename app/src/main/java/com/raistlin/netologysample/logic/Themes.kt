package com.raistlin.netologysample.logic

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

data class Theme(val title: String, val courses: Int, val color: String)

fun parseThemes(jsonString: String): List<Theme> {
    val result = mutableListOf<Theme>()
    try {
        val json = JSONObject(jsonString)
        val data = json.optJSONArray("data")
        data?.let {
            for (i in 0 until data.length()) {
                val themeObject = data.getJSONObject(i)
                val groups = themeObject.getJSONArray("groups")
                val direction = themeObject.getJSONObject("direction")
                val badge = direction.getJSONObject("badge")
                result.add(Theme(direction.getString("title"), calcCourses(groups), badge.getString("bgColor")))
            }
        }
    } catch (ex: JSONException) {
    }
    return result
}

private fun calcCourses(groups: JSONArray): Int {
    val metaGroups = mutableListOf<JSONObject>()
    for (i in 0 until groups.length()) {
        metaGroups.add(groups.getJSONObject(i))
    }
    return metaGroups.sumBy { it.getJSONArray("items").length() }
}