package com.example.designpatterns.patterns.factory

interface FileParserFactory {
    fun createFromFileName(fileName: String): FileParserFactory
}

class StandardFileParserFactory : FileParserFactory {
    override fun createFromFileName(fileName: String) =
        when (fileName.substringAfterLast('-')) {
            "xml" -> XmlFileParse()
            "json" -> JsonFileParse()
            else -> throw Exception("I don't know how to deal with $fileName")
        }
}

class XmlFileParse : FileParserFactory {
    override fun createFromFileName(fileName: String): FileParserFactory {
        return XmlFileParse()
    }
}

class JsonFileParse : FileParserFactory {
    override fun createFromFileName(fileName: String): FileParserFactory {
        return JsonFileParse()
    }
}