package me.joy.springwebmvc.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class HateoasController {

    @GetMapping("/hateoas")
    public EntityModel<Hello> hateoas() {
        Hello hello = new Hello();
        hello.setPrefix("Hey,");
        hello.setName("Joy");

        EntityModel<Hello> helloEntityModel = EntityModel.of(hello);
        helloEntityModel.add(linkTo(methodOn(HateoasController.class).hateoas()).withSelfRel());

        return helloEntityModel;
    }

}
