package edu.AnastasiiaTkachuk

class IORunner {
    static void main(String[] args) {
        def file = new File(".gitignore")
        println file.text //считывание файла

        file.each {line -> println line} //считывание построчно

        file.withInputStream {
            def allText = new String(it.readAllBytes())
            println allText
        }
        def writer = new StringWriter()
        try(def reader = file.newReader()){
            writer << reader
        }

        def file2 = new File("text.txt")
        file2.text = "Some text"
        file2 << "New line" << System.lineSeparator()

        def srcDir = new File("src")
        srcDir.eachDirRecurse { println it}
    }
}
