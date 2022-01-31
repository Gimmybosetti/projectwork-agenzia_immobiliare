//seleziono tutti i cuoricini che sono nell'HTML in un array al 
//al posto di .cuore metti la classe che hai scelto per identificarli tutti 
let cuoriciniLista = document.querySelectorAll('.cuore');

//riprova per sapere se hai selezionato tutti i cuoricini in HTML
console.log(`I cuoricini sono ${cuoriciniLista.length}`);

//aggiungo un event Listener a ogni cuoricino e un attributo indice per distinguerli
for(let i = 0; i < cuoriciniLista.length; i++){
    cuoriciniLista[i].addEventListener('click', cliccato);
    cuoriciniLista[i].setAttribute('numero-cuoricino', i);
}

//funzione che mi dice l'indice del cuoricino che ha sollecitato event listener
function cliccato(evento) {
    let cuoricino = evento.currentTarget;
    console.log(cuoricino.getAttribute('numero-cuoricino'));
    let indice = cuoricino.getAttribute('numero-cuoricino');
    return indice;
}

//creo una lista di zeri per settare il colore azzurro dei cuoricini e usarla come contatore dello stato colore
let newBottonePigiato = [];
for(let j = 0;j < cuoriciniLista.length;j++){
    newBottonePigiato.push(0);
}

//aggiungo un secondo event listener per far cambiare il colore ai bottoni
for(let j = 0; j < cuoriciniLista.length; j++){
        cuoriciniLista[j].addEventListener('click',redToBluRori);
    }

function redToBluRori(evento2){
    let index = evento2.currentTarget.getAttribute('numero-cuoricino');
    if(newBottonePigiato[index]  % 2 == 0){
    cuoriciniLista[index].style.color='#FF0000';


    }else{

        cuoriciniLista[index].style.color='#6495ed';
    }
    newBottonePigiato[index]++;
}






