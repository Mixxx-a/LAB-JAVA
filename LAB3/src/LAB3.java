public class LAB3 {
    public static void main(String[] args) {
        // класс IniFile парсит .ini файл на массив секций
        IniFile parsedFile = new IniFile("test.ini");

        // проверка ошибки FileFormat
        IniFile parsedFileError = new IniFile("test.txt");

        int int1 = parsedFile.getIntValue("COMMON", "LogNCMD");
        int int2 = parsedFile.getIntValue("COM", "LogNCMD");
        int int3 = parsedFile.getIntValue("COMMON", "Log");
        int int4 = parsedFile.getIntValue("COMMON", "DiskCachePath");

        float float1 = parsedFile.getFloatValue("ADC_DEV", "BufferLenSeconds");
        float float2 = parsedFile.getFloatValue("NCMD", "EnableChannelControl");
        float float3 = parsedFile.getFloatValue("ADC_DEV", "Driver");

        String str1 = parsedFile.getStringValue("LEGACY_XML", "ListenTcpPort");
        String str2 = parsedFile.getStringValue("NCMD", "SampleRate");
        String str3 = parsedFile.getStringValue("ADC_DEV", "Driver");






    }
}