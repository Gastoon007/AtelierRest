package ressources;

import entities.Etudiant;
import entities.Option;
import metiers.EtudiantBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Path("/etudiants")
public class EtudiantRessources {
    public static EtudiantBusiness etudiantBusiness = new EtudiantBusiness();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ajouterEtudiant(Etudiant e){
        if(etudiantBusiness.addEtudiant(e))
            return Response.status(Status.NOT_FOUND).build();
        return Response.status(Status.OK).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListEtudiants(@QueryParam("option") int codeOption){
        List<Etudiant> res;
        if(codeOption == 0){
            res=etudiantBusiness.getAllEtudiants();
        }else {
            res=etudiantBusiness.getEtudiantsByOption(new Option(codeOption,null,null,null,0,0,0));
        }
        if(res.isEmpty())
            return Response.status(Status.NOT_FOUND).build();
        return Response.status(Status.OK).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getEtudiantbyIdentifiant(@PathParam("id") String identifiant){
        Etudiant res=etudiantBusiness.getEtudiantByIdentifiant(identifiant);
        if(res == null)
            return Response.status(Status.NOT_FOUND).entity(res).build();
        return Response.status(Status.OK).build();
    }

    @DELETE
    @Path("{code}")
    public Response supprimerEtudiant(@PathParam("code") String identifiant){
        if(etudiantBusiness.deleteEtudiant(identifiant))
            return Response.status(Status.NO_CONTENT).build();
        return Response.status(Status.NOT_FOUND).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{icode}")
    public Response modifierEtudiant(Etudiant e, @PathParam("icode") String identifiant){
        if (etudiantBusiness.updateEtudiant(identifiant,e))
            return Response.status(Status.OK).build();
        return Response.status(Status.NOT_FOUND).build();
    }
}
