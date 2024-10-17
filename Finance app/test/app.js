const { MongoClient} = require("mongodb")
const uri = require ("./atlas_uri")

console.log(uri)

const client = new MongoClient(uri)
const dbname = "bank"

const connect = async () => {
    try{
        await client.connect();
        console.log(`Connected to the ${dbname} atabase`);
    }
    catch(error){
        console.error(`error connecting to the database ${error}`);
    }
  
};

const main = async () => {
    try{
        await client.connect();
        console.log(`Connected to the ${dbname} atabase`);
    }
    catch(error){
        console.error(`error connecting to the database ${error}`);
    }
    finally{
        await client.close();
    }
  
};

main();
