package greed.conf;

import greed.conf.meta.Conflict;
import greed.conf.meta.Optional;
import greed.conf.meta.Required;
import greed.conf.meta.Stub;

/**
 * Greed is good! Cheers!
 */
public class TemplateConfig {
    @Required
    private boolean override;

    @Optional
    private String outputKey;

    @Conflict(withField = { "outputFileName", "outputFileExtension" })
    @Optional
    @Stub
    private String outputFile;

    @Optional
    private String outputFileName;
    @Optional
    private String outputFileExtension;

    @Optional
    private CommandConfig afterGen;

    public boolean isOverride() {
        return override;
    }

    public void setOverride(boolean override) {
        this.override = override;
    }

    public String getOutputKey() {
        return outputKey;
    }

    public void setOutputKey(String outputKey) {
        this.outputKey = outputKey;
    }

    public String getOutputFile() {
        return getOutputFileName() + "." + getOutputFileExtension();
    }

    public void setOutputFile(String outputFile) {
        int dot = outputFile.lastIndexOf(".");
        if (dot == -1) {
            setOutputFileName(outputFile);
            setOutputFileExtension("");
        }
        else {
            setOutputFileName(outputFile.substring(0, dot));
            setOutputFileExtension(outputFile.substring(dot + 1));
        }
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public String getOutputFileExtension() {
        return outputFileExtension;
    }

    public void setOutputFileExtension(String outputFileExtension) {
        this.outputFileExtension = outputFileExtension;
    }

    public CommandConfig getAfterGen() {
        return afterGen;
    }

    public void setAfterGen(CommandConfig afterGen) {
        this.afterGen = afterGen;
    }
}
