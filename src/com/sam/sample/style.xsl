<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <css>
            .hbox {
                <!---fx-background-color: #2f4f4f;-->
                -fx-background-color: red;
                -fx-padding: 15;
                -fx-spacing: 10;
            }
        </css>
        <xsl:apply-templates/>
    </xsl:template>
</xsl:stylesheet>