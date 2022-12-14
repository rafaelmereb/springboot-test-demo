// ES6 (2015)
/**
 * -> Declaração de variáveis com let e const
 * -> Arrow Functions
 * -> Classes
 * -> Template Strings
 * -> Promises
 * -> Etc.
 */

async function dormir(porQuantoTempo) {
    function timeout(ms) {
        return new Promise(resolve => setTimeout(resolve, ms))
    }
    await timeout(porQuantoTempo);
}

async function contarAteTres() {
    await dormir(0);
    console.log(3);

    await dormir(1000);
    console.log(2);

    await dormir(1000);
    console.log(1);

    await dormir(1000);
    console.log("YAY")
}

// ES7 (2016)
/**
 * -> Array includes: [1, 2, 3].includes(1) // => true
 * -> Operador de exponenciação // -> 
 */







// ES8 (2017)
/**
 * -> Async functions
 * -> Object.entries Object.values: objeto -> array
 * -> String padding
 */
console.log("ES8:")

var obj = { 1: "Javascript", 2: "HTML", 3: "CSS" };
var map = new Map(Object.entries(obj));
console.log("> var map = new Map(Object.entries(obj));")
console.log(map);

// String padding:
"abc".padStart(4); // " abc"
"abc".padStart(5, "-"); // "--abc"
"Fe".padStart(10, "xxx ") // "xxx xxx Fe"
"Fernanda".padStart(2) // nao faz nada porque é menor que a string

"abc".padEnd(4) // "abc "
// ...