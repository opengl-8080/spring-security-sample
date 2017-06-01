<c:url var="cssUrl" value="/css/style.css" />
<link rel="stylesheet" href="${cssUrl}" />

<style>
body {
  background-color: ${pageContext.servletContext.getInitParameter('backgroundColor')};
}
</style>
