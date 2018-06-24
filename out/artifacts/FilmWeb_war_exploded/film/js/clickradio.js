function clickRadioValue()
{
    var radio = $("input[name='xx']:checked").val();
    console.log(radio);
    if(radio=="fname")
    {
        document.getElementById("fn").style.visibility= "visible";
        document.getElementById("fn").style.display="";
        document.getElementById("ft").style.visibility= "hidden";
        document.getElementById("tj").style.visibility= "visible";
        document.getElementById("ft").style.display="none";
    }
    if(radio=="ftype")
    {
        document.getElementById( "fn").style.visibility= "hidden";
        document.getElementById( "ft").style.visibility= "visible";
        document.getElementById( "ft").style.display= "";
        document.getElementById( "tj").style.visibility= "visible";
        document.getElementById("fn").style.display="none";
        document.getElementById("test").style.display="inline";

    }
}
