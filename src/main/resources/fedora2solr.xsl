<?xml version="1.0" encoding="UTF-8"?>
<!--
  ~ This program is free software: you can redistribute it and/or modify
  ~ it under the terms of the GNU General Public License as published by
  ~ the Free Software Foundation, either version 3 of the License, or
  ~ (at your option) any later version.
  ~
  ~ This program is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~ MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
  ~ GNU General Public License for more details.
  ~
  ~ You should have received a copy of the GNU General Public License
  ~ along with this program. If not, see <http://www.gnu.org/licenses/>.
  -->

<xsl:stylesheet version="2.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
				xmlns:dc="http://purl.org/dc/elements/1.1/"
				exclude-result-prefixes="rdf dc">

	<xsl:output method="xml" indent="yes" encoding="utf-8" omit-xml-declaration="yes"/>
	
	<xsl:template match="/">
			<doc>
				<xsl:apply-templates select="rdf:RDF"/>
			</doc>
	</xsl:template>
	
	<xsl:template match="rdf:Description">
		<field name="id">
			<xsl:value-of select="@rdf:about"/>
		</field>
		<xsl:apply-templates/>
	</xsl:template>	
	
	<xsl:template match="dc:creator">
		<field name="creator">
			<xsl:value-of select="./text()"/>
		</field>
	</xsl:template>
	
	<xsl:template match="dc:abstract">
		<field name="abstract">
			<xsl:value-of select="./text()"/>
		</field>
	</xsl:template>

	<xsl:template match="dc:language">
		<field name="language">
			<xsl:value-of select="./text()"/>
		</field>
	</xsl:template>

	<xsl:template match="dc:description">
		<field name="description">
			<xsl:value-of select="./text()"/>
		</field>
	</xsl:template>

	<xsl:template match="dc:author">
		<field name="author">
			<xsl:value-of select="./text()"/>
		</field>
	</xsl:template>

	<xsl:template match="dc:title">
		<field name="title">
			<xsl:value-of select="./text()"/>
		</field>
	</xsl:template>

	<xsl:template match="dc:format">
		<field name="format">
			<xsl:value-of select="substring('test',3)"/>
		</field>
	</xsl:template>
	
	<xsl:template match="text()"/>

</xsl:stylesheet>
