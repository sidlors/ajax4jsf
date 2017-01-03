<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<f:view>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"" />
<link rel="stylesheet" 
      href="./css/styles.css" 
      type="text/css"/>
<title>Ajax4jsf Examples</title>
</head>
<body>
<table border="5" align="center">
  <tr><th class="title">Ajax4jsf Examples</th></tr>
</table>
<p/>
<fieldset>
<legend>a4j:commandButton and a4j:commandLink</legend>
<p/>
<table border="1">
  <tr><th>Control</th>
      <th>Result</th>
  </tr>
  <tr><td width="100">
        <h:form>
          <a4j:commandButton action="#{numBean.makeResult}"
                             value="Show Random Number" 
                             reRender="region1"/>
        </h:form>
      </td>
      <td width="100">
        <h:outputText value="#{numBean.result}" id="region1"/>
      </td>
  </tr>
  <tr><td width="100">
        <h:form>
          <a4j:commandLink action="#{numBean.makeResult}"
                           value="Show Random Number" 
                           reRender="region2"/>
        </h:form>
      </td>
      <td width="100">
        <h:outputText value="#{numBean.result}" id="region2"/>
      </td>
  </tr>
  <tr><td width="100">
        <h:form>
          Range: 
          <h:inputText value="#{numBean.range}"
                       size="5"/><br/>
          <a4j:commandButton action="#{numBean.makeResult}"
                             value="Show Random Number" 
                             reRender="region3"/>
        </h:form>
      </td>
      <td width="100">
        <h:outputText value="#{numBean.result}" id="region3"/>
      </td>
  </tr>
</table>
</fieldset>
<p/>
<fieldset>
<legend>a4j:poll</legend>
<h:form>
  <a4j:poll interval="5000" reRender="timeDisplay"/>
  <h2>
    <h:outputText value="#{timeBean.time}" id="timeDisplay"/>
  </h2>
</h:form>
</fieldset>
<p/>
<fieldset>
  <legend>Sample: Repeater</legend>
  <h:form>
    <table border="1">
      <tr><th>Textfield</th>
          <th>Ajax Value</th>
      </tr>
      <tr><td width="100">
          <h:inputText value="#{myBean.message}">
            <a4j:support event="onkeyup" reRender="message-region"/>
          </h:inputText></td>
          <td width="100">
          <b><font color="red" size="6">
          <h:outputText value="#{myBean.message}" id="message-region"/>
          </font></b>
          </td>
      </tr>
    </table>
  </h:form>
</fieldset>
<p/>
<fieldset>
<legend>h:selectOneMenu with a4j:support</legend>
<p/>
<h:form>
  State:
  <h:selectOneMenu value="#{locationBean.state}">
    <f:selectItems value="#{locationBean.states}"/>
    <a4j:support event="onchange" reRender="cityList"/>
  </h:selectOneMenu>
  <br/>
  City:
  <h:selectOneMenu value="#{locationBean.city}"
                   disabled="#{locationBean.cityListDisabled}"
                   id="cityList">
    <f:selectItems value="#{locationBean.cities}"/>
    <a4j:support event="onchange" reRender="population"/>
  </h:selectOneMenu>
  <br/>
  Population:
  <h:outputText value="#{locationBean.city}" 
                escape="false"
                id="population"/>
</h:form>
</fieldset>

<br/><br/><br/><br/>
<p>
Taken from 
<a href="http://www.coreservlets.com/JSF-Tutorial/">
the coreservlets.com JSF 1.x and JSF 2.0 tutorials</a>.</p>
</body></html>
</f:view>